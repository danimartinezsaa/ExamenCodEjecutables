/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dani.ejecutable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category="File",
        id="com.dani.ejecutable.BotonActionListener"
)
@ActionRegistration(
        iconBase="com/dani/ejecutable/add.png",
        displayName="#CTL_BotonActionListener"
)
@ActionReference(path="Toolbars/File", position=0)
@Messages("CTL_BotonActionListener=CrearDeb")

/**
 * Al pulsar el botón dispara la siguiente clase.
 */
public final class BotonActionListener implements ActionListener{
/**
 * Al darle al botón ejecuta el siguiente método, que pide los datos necesarios para ejecutar el comando.
 * @param e ActionEvent
 */
    @Override
    public void actionPerformed(ActionEvent e){
        //String en dónde se almacenan los datos introducidos por el usuario.
        String directorio, fichero, clase, extension, dirsalida,nombre;
        //Ventanas para introducir los datos.
        directorio=JOptionPane.showInputDialog("Inserte directorio del Jar");
        fichero=JOptionPane.showInputDialog("Inserte fichero Jar");
        clase=JOptionPane.showInputDialog("Inserte paquete.Main");
        extension=JOptionPane.showInputDialog("Inserte extensión (exe/deb)");
        dirsalida=JOptionPane.showInputDialog("Inserte directorio de salida");
        nombre=JOptionPane.showInputDialog("Inserte nombre de la nueva app");

        try{
            //En un Array (String) almaceno todo el comando.
            String [] cmd = {"javapackager","-deploy","-native", extension,"-outdir",dirsalida,"-outfile",nombre,"-srcdir",directorio,"-srcfiles",fichero,"-appclass",clase,"-name",nombre,"-title",nombre};
            /**
             * Creo un objeto Process y de la clase Runtime accedo a los métodos estáticos siguientes,
             * al método exec le paso el Array con el comando
             */
            Process process = Runtime.getRuntime().exec(cmd);
            //con el getInputStream() podemos obtener un Stream para poder leer lo que el comando que ejecutamos escribío en la consola.
            InputStream inputstream = process.getInputStream();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
            JOptionPane.showMessageDialog(null,"Comando ejecutado con éxito.");
        }catch(IOException ioe){
            System.out.println("Error al ejecutar comando");
        }
    }
}
