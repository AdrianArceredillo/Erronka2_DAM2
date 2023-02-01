from odoo.tests.common import TransactionCase


class TestPartida(TransactionCase):

    def setUp(self, *args, **kwargs):
        super().setUp(*args, **kwargs)
        user_admin = self.env.ref("base.user_admin")
        self.env = self.env(user=user_admin)
        self.Partida = self.env["library.partida"]
        self.partida1 = self.Partida.create({
            "name": "Odoo Development Essentials",
            "isbn": "879-1-78439-279-6"})

    def test_partida_create(self):
        "New Partidak are active by default"
        self.assertEqual(
            self.partida1.active, True
        )

    def test_check_isbn(self):
        "Check valid ISBN"
        self.assertTrue(self.partida1._check_isbn)
