from odoo import tools
from odoo import fields, models

class PartidakOrdenatuta(models.Model):
    
    _name = 'partidak.ordenatuta'
    _auto = False
    _description = 'Partidak Ordenatuta View'

    erabiltzailea = fields.Char("erabiltzailea")
    max = fields.Integer("puntuazioa")
    

