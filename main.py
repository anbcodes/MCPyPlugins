from py4j.java_gateway import JavaGateway
import py4j
import time
from importlib import import_module
import os

t = 0
while True:
    try:
        gateway = JavaGateway()    
        app = gateway.entry_point
        value = app.run("say pythoncommands is loaded")
        print(value)
        break
    except (py4j.protocol.Py4JNetworkError, IndexError, ConnectionRefusedError):
        if t < 1:
            print("connecting")
            t += 1
    time.sleep(0.2)
print("connected")
v = app.run("say connected")
plugins = {}
#loadingplugins
for file in os.listdir("."):
    if file[0] != "." and file != "MCPyPlugin" and os.path.isdir(file):
        plugins[file] = import_module(file).PyPlugin(app)

#tick Loop
tickcount = 0
while True:
    for x in plugins.values():
        x.tick(tickcount)
    time.sleep(0.05)
    tickcount += 1