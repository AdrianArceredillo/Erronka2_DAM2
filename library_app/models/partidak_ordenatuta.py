from odoo import tools
from odoo import fields, models

class PartidakOrdenatuta(models.Model):
    
    _name = 'partidak.ordenatuta'
    _auto = False
    _description = 'Partidak Ordenatuta View'
    
    erabiltzailea = fields.Char("erabiltzailea")
    max = fields.Integer("puntuazioa")
    
    def init(self):
    
        tools.drop_view_if_exists(self._cr, self._table)
        query = """
                  SELECT res_partner.id,
    res_partner.name AS erabiltzailea,
    max(library_partida.puntuazioa) AS max
   FROM res_partner
     JOIN library_partida ON res_partner.id = library_partida.langilea
  GROUP BY res_partner.id, res_partner.name
  ORDER BY (max(library_partida.puntuazioa)) DESC
        """
        self.env.cr.execute("""CREATE or REPLACE VIEW %s as (%s)""" % (self._table, query))

