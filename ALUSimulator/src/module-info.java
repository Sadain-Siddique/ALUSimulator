module BinaryCalculator {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires com.jfoenix;
	requires javafx.base;
	opens application to javafx.graphics, javafx.fxml;
}
