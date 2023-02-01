from odoo import fields, models
from odoo.exceptions import ValidationError


class Partida(models.Model):
    """
    Describes a Partida catalogue.
    """
    _name = "library.partida"
    _description = "Partida"

    id = fields.Integer("Partida Id")
    puntuazioa = fields.Integer("Puntuazioak")
    data = fields.Date()
    active = fields.Boolean("Active?", default= True)
    langilea = fields.Many2one("res.partner", string="Langileak")


    
