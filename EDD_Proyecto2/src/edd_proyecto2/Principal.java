/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2;

import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author joshu
 */
public class Principal extends javax.swing.JFrame {

    //***filtro de archivo json
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON", "json");
    
    //ESTRUCTURA
    TablaDispersion.Lista tablaDispersion;
    
    
    public Principal(TablaDispersion.Lista tablaDispersion) {
        this.tablaDispersion = tablaDispersion;//recibo la estructura
        initComponents();//componentes de la ventana
        setTitle("Inicio de Session");//titulo de la ventana
        setLocationRelativeTo(null);//posicion en el centro
        setVisible(true);//visibilidad de la ventana
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        lbNombreUsuario = new javax.swing.JLabel();
        lbPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lbCargaMasiva = new javax.swing.JLabel();
        btnCargaArchivo = new javax.swing.JButton();
        txtRutaArchivo = new javax.swing.JTextField();
        lbNombreArchivo = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        btnRegistrarDatos = new javax.swing.JButton();
        btnPrueba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lbNombreUsuario.setText("Usuario");

        lbPassword.setText("Password");

        btnRegistrar.setText("Registrarse");

        lbCargaMasiva.setText("realizar carga Masiva ");

        btnCargaArchivo.setText("Cargar Archivo");
        btnCargaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaArchivoActionPerformed(evt);
            }
        });

        lbNombreArchivo.setText("Nombre Archivo");

        btnRegistrarDatos.setText("Registar Datos");
        btnRegistrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDatosActionPerformed(evt);
            }
        });

        btnPrueba.setText("jButton1");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCargaMasiva)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar))
                            .addComponent(txtUsuario)
                            .addComponent(txtPassword))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombreArchivo)
                            .addComponent(btnCargaArchivo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrarDatos)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNombreArchivo)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrueba)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnRegistrar))
                .addGap(32, 32, 32)
                .addComponent(btnPrueba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(lbCargaMasiva)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargaArchivo)
                    .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNombreArchivo)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarDatos)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //EVENTO DEL BOTOTN
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        int carnet = Integer.parseInt(txtUsuario.getText());
        int posicion = tablaDispersion.funcionDispersion(carnet);
        //tablaDispersion.insertar(posicion);
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    //EVENTO PARA LA CARGA DEL ARCHIVO JSON
    private void btnCargaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaArchivoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JFileChooser buscadorArchivos = new JFileChooser();
        //***** agregando filtro de archivos json al buscador 
        buscadorArchivos.setFileFilter(filtro);//archivo json
        
        String nombreArchivo="",rutaArchivo="";
        
        int opcion = buscadorArchivos.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            //mostrar el nombre del archivo selecionado
            nombreArchivo = buscadorArchivos.getSelectedFile().getName();
            //ruta del archivo
            rutaArchivo = buscadorArchivos.getSelectedFile().toString();
        }
        
        //********los muestro en los txt
        txtRutaArchivo.setText(rutaArchivo);
        txtNombreArchivo.setText(nombreArchivo);
    }//GEN-LAST:event_btnCargaArchivoActionPerformed

    //EVENTO PARA REGISTAR LOS DATOS EN LA TABLA HASH
    private void btnRegistrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDatosActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JSONParser parser = new JSONParser();
        try {
            //*********lectura del archivo json
            Object obj = parser.parse(new FileReader(txtRutaArchivo.getText()));
            JSONObject jsonObject = (JSONObject) obj; 
            JSONArray lista = (JSONArray) jsonObject.get("CREAR_USUARIO");//para buscar categorias
            //**CICLO PARA RECORRE TODO EL ARRAY
            for(int i = 0; i < lista.size(); i++){
                JSONObject usuarioNuevo = (JSONObject) lista.get(i);
                int carnet = Integer.parseInt("" +usuarioNuevo.get("Carnet"));//obtengo el valor
                String nombre = "" + usuarioNuevo.get("Nombre");
                String apellido = "" + usuarioNuevo.get("Apellido");
                String carrera = "" + usuarioNuevo.get("Carrera");
                String password = "" + usuarioNuevo.get("Password");
                //envio de datos a la estructura
                tablaDispersion.insertar(carnet,nombre,apellido,carrera,password);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nose puedo cargar el archivo \n"+e);
        }
    }//GEN-LAST:event_btnRegistrarDatosActionPerformed

    //prueba para graficar la tabla dispersa
    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        // TODO add your handling code here:
        tablaDispersion.reporteHash();
    }//GEN-LAST:event_btnPruebaActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargaArchivo;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnPrueba;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCargaMasiva;
    private javax.swing.JLabel lbNombreArchivo;
    private javax.swing.JLabel lbNombreUsuario;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRutaArchivo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
