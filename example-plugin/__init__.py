class PyPlugin:
    def __init__(self, app):
        self.app = app
        self.where = 1
    def tick(self, tickcount):
        if tickcount % 20 == 0:
            print(self.app.run("data get entity @e[limit=1]"))