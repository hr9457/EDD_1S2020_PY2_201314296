/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_proyecto2;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author joshu
 */
public class VentanaUsuario extends javax.swing.JFrame{

    //estructuras
    ArbolAVL.ArbolAVL arbolCategorias;
    TablaDispersion.Lista tablaHash;
    
    Principal ventanaInicio;
    int carnet;
    //ImageIcon imagen;

    /**
     * Creates new form VentanaUsuario
     */
    public VentanaUsuario(Principal ventanaInicio, int carnet, ArbolAVL.ArbolAVL arbolCategorias, TablaDispersion.Lista tablaHash) {
        this.ventanaInicio = ventanaInicio;
        this.carnet = carnet;
        this.arbolCategorias = arbolCategorias;
        this.tablaHash = tablaHash;
        //creacion de scrolbar
        //ImageIcon imagen = new ImageIcon();
        initComponents();
        lbCarnetUsuario.setText("" + carnet);
        //lbVisor.setVisible(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lbUsuario = new javax.swing.JLabel();
        lbCarnetUsuario = new javax.swing.JLabel();
        lbCrearCategoria = new javax.swing.JLabel();
        btnCrearCategoria = new javax.swing.JButton();
        lbCrearLibro = new javax.swing.JLabel();
        btnAgregarLibro = new javax.swing.JButton();
        lbBiblioteca = new javax.swing.JLabel();
        btnVerCategorias = new javax.swing.JButton();
        btnVerLibros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbVisor = new javax.swing.JLabel();
        btnPreorden = new javax.swing.JButton();
        btnPostorden = new javax.swing.JButton();
        btnInorden = new javax.swing.JButton();
        btnHashReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        lbEliminarLibro = new javax.swing.JLabel();
        btnEliminarCategoria = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnMinar = new javax.swing.JButton();
        btnAbrirReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSalir.setText("Cerrar Session");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lbUsuario.setText("USUARIO: ");

        lbCrearCategoria.setText("Crear una Categoria de Libros");

        btnCrearCategoria.setText("Crear Categoria");
        btnCrearCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCategoriaActionPerformed(evt);
            }
        });

        lbCrearLibro.setText("Agregar un libro a la Biblioteca");

        btnAgregarLibro.setText("Agregar Libro");

        lbBiblioteca.setText("Biblioteca");

        btnVerCategorias.setText("Ver Categorias");
        btnVerCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerCategoriasActionPerformed(evt);
            }
        });

        btnVerLibros.setText("Ver libros");

        lbVisor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVisor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jScrollPane1.setViewportView(lbVisor);

        btnPreorden.setText("Categoras Pre");
        btnPreorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreordenActionPerformed(evt);
            }
        });

        btnPostorden.setText("Categorias Post");
        btnPostorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostordenActionPerformed(evt);
            }
        });

        btnInorden.setText("Categorias Inor");
        btnInorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInordenActionPerformed(evt);
            }
        });

        btnHashReporte.setText("Usuarios ");
        btnHashReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHashReporteActionPerformed(evt);
            }
        });

        jLabel1.setText("Editar Datos");

        btnEdit.setText("Editar Datos");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lbEliminarLibro.setText("Eliminar una Categoria ");

        btnEliminarCategoria.setText("Eliminar Categoria");
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setText("Eliminar Cuenta");
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        btnMinar.setText("Minar");

        btnAbrirReporte.setText("Abrir Reporte");
        btnAbrirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirReporteActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVerCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPreorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPostorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHashReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAbrirReporte))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(lbCarnetUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbEliminarLibro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbBiblioteca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbCrearLibro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbCrearCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCrearCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAgregarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(277, 313, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(btnMinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCarnetUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalir)
                        .addComponent(lbUsuario)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnMinar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCuenta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnEdit))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearCategoria)
                            .addComponent(lbCrearCategoria))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEliminarLibro)
                            .addComponent(btnEliminarCategoria))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCrearLibro)
                            .addComponent(btnAgregarLibro))))
                .addGap(123, 123, 123)
                .addComponent(lbBiblioteca)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVerCategorias)
                        .addGap(18, 18, 18)
                        .addComponent(btnInorden)
                        .addGap(12, 12, 12)
                        .addComponent(btnPreorden)
                        .addGap(18, 18, 18)
                        .addComponent(btnPostorden)
                        .addGap(18, 18, 18)
                        .addComponent(btnHashReporte)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerLibros)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrirReporte))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
        ventanaInicio.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    //EVENTO PARA CREAR CATEGORIAS Y HACER CARA MASIVA EN EL ARBOL AVL
    private void btnCrearCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCategoriaActionPerformed
        // TODO add your handling code here:
        int carnet = Integer.parseInt(lbCarnetUsuario.getText());
        IngresoCategoria vCategoria = new IngresoCategoria(arbolCategorias,carnet);
    }//GEN-LAST:event_btnCrearCategoriaActionPerformed

    //evento para vver el arbol avl ver las categorias
    private void btnVerCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerCategoriasActionPerformed
        // TODO add your handling code here:
        ImageIcon imagen = new ImageIcon("Reportes\\ArbolAVL.png");
        lbVisor.setIcon(imagen);
    }//GEN-LAST:event_btnVerCategoriasActionPerformed

    //evento para ver el listado de las categorias en preorden
    private void btnPreordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreordenActionPerformed
        // TODO add your handling code here:
        //arbolCategorias.generarDotPreorden();        
        ImageIcon imagen = new ImageIcon("Reportes\\ArbolPreorden.png");
        lbVisor.setIcon(imagen);        
        jScrollPane1.repaint();
    }//GEN-LAST:event_btnPreordenActionPerformed

    //evento para ver reporte de postorden
    private void btnPostordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostordenActionPerformed
        // TODO add your handling code here:
        lbVisor.setIcon(null);
        ImageIcon imagen = new ImageIcon("Reportes\\ArbolPostorden.png");
        lbVisor.setIcon(imagen);
    }//GEN-LAST:event_btnPostordenActionPerformed

    //evento para ver el reporte en inorden
    private void btnInordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInordenActionPerformed
        // TODO add your handling code here:
        lbVisor.setIcon(null);
        ImageIcon imagen = new ImageIcon("Reportes\\ArbolInorden.png");
        lbVisor.setIcon(imagen);
    }//GEN-LAST:event_btnInordenActionPerformed

    //evento para ver a los demas usuarios
    private void btnHashReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHashReporteActionPerformed
        // TODO add your handling code here:
        lbVisor.setIcon(null);
        ImageIcon imagen = new ImageIcon("Reportes\\Hash.png");
        lbVisor.setIcon(imagen);
        
    }//GEN-LAST:event_btnHashReporteActionPerformed

    //edicion de datos
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int carnetUsuarioDatos = Integer.parseInt(lbCarnetUsuario.getText());
        TablaDispersion.Nodo datos = tablaHash.retornarDatos(carnetUsuarioDatos);
        EditarDatos ventanaEdicionDatos = new EditarDatos(datos);
    }//GEN-LAST:event_btnEditActionPerformed

    
    //eliminacion de cuenta
    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        // TODO add your handling code here:
        tablaHash.buscarEliminar(carnet);
        tablaHash.reporteHash();//actualizacion del reporte
        tablaHash.generarPNG();
        dispose();
        //tablaHash.abrirPNG();
        //hacer visible la ventana otra vez
        ventanaInicio.setVisible(true);
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnAbrirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirReporteActionPerformed
        // TODO add your handling code here:
        JFileChooser buscar = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("selecionar imagen", "jpg","png");
        buscar.setFileFilter(extension);
        if(buscar.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            Toolkit tool = Toolkit.getDefaultToolkit();
            String ruta = buscar.getSelectedFile().toString();
            Image imagen = tool.createImage(ruta);
            lbVisor.setIcon(new ImageIcon(imagen));
        }
    }//GEN-LAST:event_btnAbrirReporteActionPerformed

    //para eliminar una categoria en el arbol
    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        // TODO add your handling code here:
        int carnet = Integer.parseInt(lbCarnetUsuario.getText());
        VentanaEliminarCategoria ven = new VentanaEliminarCategoria(carnet,arbolCategorias);
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirReporte;
    private javax.swing.JButton btnAgregarLibro;
    private javax.swing.JButton btnCrearCategoria;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnHashReporte;
    private javax.swing.JButton btnInorden;
    private javax.swing.JButton btnMinar;
    private javax.swing.JButton btnPostorden;
    private javax.swing.JButton btnPreorden;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerCategorias;
    private javax.swing.JButton btnVerLibros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBiblioteca;
    private javax.swing.JLabel lbCarnetUsuario;
    private javax.swing.JLabel lbCrearCategoria;
    private javax.swing.JLabel lbCrearLibro;
    private javax.swing.JLabel lbEliminarLibro;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbVisor;
    // End of variables declaration//GEN-END:variables

    
}
