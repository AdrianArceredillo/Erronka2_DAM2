from odoo import http

class Partidak(http.Controller):

    @http.route("/library/partidak")
    def list(self, **kwargs):
        Partida = http.request.env["library.partida"]
        partidak = Partida.search([])

        return http.request.render(
            "library_app.partida_list_template",
            {"partidak": partidak}

        )
    
    @http.route('/partidak_ordenatuta', type='http', auth='public', website=True)
    def partidak_ordenatuta(self, **kwargs):
        partidak_ordenatuta_obj = http.request.env['partidak.ordenatuta']
        partidak_ordenatuta = partidak_ordenatuta_obj.search([])
        # partidak_ordenatuta = partidak_ordenatuta.sorted(key = lambda r: r.max, reverse = True)

        return http.request.render('library_app.partidak_ordenatuta_template', {
            'partidak_ordenatuta': partidak_ordenatuta
        })


        
