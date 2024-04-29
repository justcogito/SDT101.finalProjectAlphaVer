module project2.project2 {

    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports SDT101.finalProject;
    exports SDT101.finalProject.catalogs;
    exports SDT101.finalProject.classes;
//    exports SDT101.project2.forms;
    exports SDT101.finalProject.registers;
    exports SDT101.finalProject.registers.forms;
//    exports SDT101.project2.registers.classes;
    exports SDT101.finalProject.registers.barcodes;
    exports SDT101.finalProject.registers.prices;
    exports SDT101.finalProject.catalogs.offers;
    exports SDT101.finalProject.catalogs.forms;
    exports SDT101.finalProject.documents.receipt;

}