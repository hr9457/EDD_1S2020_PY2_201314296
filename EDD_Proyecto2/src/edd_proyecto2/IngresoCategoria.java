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
public class IngresoCategoria extends javax.swing.JFrame {
    
    //*********objeetos lectura json
    
    //***filtro de archivo json
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON", "json");

    ArbolAVL.ArbolAVL arbolCategorias;
    
    int carnet;

    //constructor
    public IngresoCategoria(ArbolAVL.ArbolAVL arbolCategorias,int carnet) {
        this.arbolCategorias = arbolCategorias;
        this.carnet = carnet;
        initComponents();//inicializa componentes
        setLocationRelativeTo(null);//se sentra en el centro
        setVisible(true);//hace visible la ventnay 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnCargaMasiva = new javax.swing.JButton();
        txtRutaJSON = new javax.swing.JTextField();
        lbTituloCarga = new javax.swing.JLabel();
        btnRegistroMasivo = new javax.swing.JButton();
        txtNombreArchivo = new javax.swing.JTextField();
        lbNombreArchivo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbCategoria.setText("Categoria Individual");

        btnIngresar.setText("Registrar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnCargaMasiva.setText("Carga Archivo");
        btnCargaMasiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaActionPerformed(evt);
            }
        });

        lbTituloCarga.setText("Carga archivo JSON para carga masiva de datos");

        btnRegistroMasivo.setText("Ingresar Datos");
        btnRegistroMasivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroMasivoActionPerformed(evt);
            }
        });

        lbNombreArchivo.setText("Nombre del archivo ");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTituloCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIngresar)
                            .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCargaMasiva)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnReporte))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton1))
                                    .addComponent(txtRutaJSON, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistroMasivo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbNombreArchivo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreArchivo)))))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnReporte))
                .addGap(75, 75, 75)
                .addComponent(lbTituloCarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargaMasiva)
                    .addComponent(txtRutaJSON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombreArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnRegistroMasivo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //EVENTO PARA GUARDAR EN EL ARBOL AVL
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        String categoria = txtCategoria.getText();
        arbolCategorias.insertarCategoria(categoria,this.carnet);
        categoria = "";
        txtCategoria.setText("");
        arbolCategorias.generarDotAVL();//creo el dot
        arbolCategorias.generarPng();
        arbolCategorias.generarDotInorden();
        arbolCategorias.generarDotInorden();
        
        arbolCategorias.generarDotPostorden();
        arbolCategorias.generarDotPostorden();
        
        arbolCategorias.generarDotPreorden();
        arbolCategorias.generarPngPreorden();
    }//GEN-LAST:event_btnIngresarActionPerformed

    //EVENTO PARA VISUALIZAR EL ARBOL
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        arbolCategorias.generarDotAVL();
        arbolCategorias.abrirPngAVL();
    }//GEN-LAST:event_btnReporteActionPerformed

    //******EVENTO PARA SELECINAR EL ARCHIVO DE CARGA MASIVA
    private void btnCargaMasivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaActionPerformed
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
        txtNombreArchivo.setText(nombreArchivo);
        txtRutaJSON.setText(rutaArchivo);
    }//GEN-LAST:event_btnCargaMasivaActionPerformed

    //****EVENTO PARA REALIZAR LA CARGA MASIVA
    private void btnRegistroMasivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroMasivoActionPerformed
        // TODO add your handling code here:
        JSONParser parser = new JSONParser();
        try {
            //*********lectura del archivo json
            Object obj = parser.parse(new FileReader(txtRutaJSON.getText()));
            JSONObject jsonObject = (JSONObject) obj; 
            JSONArray lista = (JSONArray) jsonObject.get("CREAR_CATEGORIA");//para buscar categorias
            //**CICLO PARA RECORRE TODO EL ARRAY
            for(int i=0;i<lista.size();i++){
                JSONObject elementoCategoria = (JSONObject) lista.get(i);
                String nuevaCategoria = "" + elementoCategoria.get("NOMBRE");//obtengo el valor
                arbolCategorias.insertarCategoria(nuevaCategoria,this.carnet);//insertor en el arbolAVL
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nos e puedo cargar el archivo");
        }
        
        //****pruebas de arbol
        //arbolCategorias.prueba();
        
        //******limpio los campos 
        txtNombreArchivo.setText("");
        txtRutaJSON.setText("");
        
        //**********actualizacion para el visor
        arbolCategorias.generarDotAVL();
        arbolCategorias.generarDotInorden();
        arbolCategorias.generarDotPreorden();
        arbolCategorias.generarDotPostorden();
    }//GEN-LAST:event_btnRegistroMasivoActionPerformed

    //evento de prueba para eliminar un nodo en un arbol AVL
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String categoria = txtCategoria.getText();
        arbolCategorias.eliminarCategoria(categoria);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargaMasiva;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistroMasivo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbNombreArchivo;
    private javax.swing.JLabel lbTituloCarga;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNombreArchivo;
    private javax.swing.JTextField txtRutaJSON;
    // End of variables declaration//GEN-END:variables
}
