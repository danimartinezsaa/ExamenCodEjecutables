/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dani.ejecutable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
public final class BotonActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
        String directorio, fichero, clase, extension, dirsalida,nombre;

        directorio=JOptionPane.showInputDialog("Inserte directorio del Jar");
        fichero=JOptionPane.showInputDialog("Inserte fichero Jar");
        clase=JOptionPane.showInputDialog("Inserte paquete.Main");
        extension=JOptionPane.showInputDialog("Inserte extensión (exe/deb)");
        dirsalida=JOptionPane.showInputDialog("Inserte directorio de salida");
        nombre=JOptionPane.showInputDialog("Inserte nombre de la nueva app");

        try{
            String cmd="javapackager -deploy -native "+extension+" -outdir "+dirsalida+" -outfile MiApp -srcdir "+directorio+" -srcfiles "+fichero+" -appclass "+clase+" -name MiApp -title \"MiApp\"";
            Runtime.getRuntime().exec(cmd);
            JOptionPane.showMessageDialog(null,"Comando ejecutado con éxito.");
        }catch(IOException ioe){
            System.out.println("Error al ejecutar comando");
        }
    }
}
