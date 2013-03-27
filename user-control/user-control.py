#!/usr/bin/env python

import gobject
import gtk
from mysql.connector import connect

class UserControl:

  # Configuracion de la conexion.
  CONNECT_CONFIG = {
    'user':     'root',
    'password': 'root',
    'host':     'localhost',
    'database': 'openbravo'
  }

  def __init__(self):
    # Creamos la ventana de la aplicacion.
    self.window = gtk.Window()    
    self.window.connect('destroy', lambda w: gtk.main_quit())
    self.window.set_title('User Control')      
    self.window.set_position(gtk.WIN_POS_CENTER_ALWAYS)
    
    # Obtenemos los usuarios.
    users = self.request_users()
    
    # Modelo de la lista.
    model = gtk.TreeStore(gobject.TYPE_STRING,
                          gobject.TYPE_BOOLEAN)
    
    # Agregamos los elementos a la lista.
    for name, status in users.items():
      model.append(None, (name, status == 1))
      
    # Para los nombres.
    name_renderer = gtk.CellRendererText()
    name_renderer.set_property('editable', False)
    
    # Para el cambio de estado.
    status_renderer = gtk.CellRendererToggle()
    status_renderer.set_property('activatable', True)
    status_renderer.connect('toggled', self.on_status_changed, model)
    
    # Creamos las columnas.
    name_column = gtk.TreeViewColumn('Nombre', name_renderer, text = 0)
    status_column = gtk.TreeViewColumn('Disponible', status_renderer, active = 1)
      
    view = gtk.TreeView(model)
    view.append_column(name_column)
    view.append_column(status_column)
    
    self.window.add(view)
    self.window.show_all()
  
  def request_users(self):
    # Nos conectamos a la base de datos.
    connection = connect(**UserControl.CONNECT_CONFIG)
    cursor = connection.cursor()  
    
    # Realizamos la consulta.
    cursor.execute('SELECT NAME, STATUS FROM PEOPLE ORDER BY NAME')
    
    # Lista con la informacion de los usuarios.
    users = {}
    
    # Agregamos los usuarios.
    for (name, status) in cursor:
      users[name] = status
    
    # Cerramos el cursor.
    cursor.close()
    
    # Cerramos la conexion.
    connection.close()
      
    return users
    
  def request_status_change(self, name, status):
    # Nos conectamos a la base de datos.
    connection = connect(**UserControl.CONNECT_CONFIG)
    cursor = connection.cursor()  
    
    # Realizamos la consulta.
    cursor.execute("UPDATE PEOPLE SET STATUS = {0} WHERE NAME = '{1}'".format(status, name))
    
    # Guardamos los cambios.
    connection.commit()
    
    # Cerramos el cursor.
    cursor.close()
    
    # Cerramos la conexion.
    connection.close()
  
  def on_status_changed(self, cell, index, model):
    # Obtenemos la informacion del usuario.
    data = model[index]
    
    # Cambiamos el estado.
    data[1] = not data[1]
    
    # Guardamos la informacion.
    self.request_status_change(data[0], data[1])    
  
  def main(self):
    gtk.main()

def main():
  control = UserControl()
  control.main()

if __name__ == '__main__':
  main()
