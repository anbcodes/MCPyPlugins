class plugin:
    def __init__(self, app):
        self.app = app
        self.where = 1
    def tick(self, tickcount):
        print(self.app.run("data get entity @p"))