CREATE TABLE Producto (ID int(10) NOT NULL AUTO_INCREMENT, OfertaID int(10) NOT NULL, CategoriaID int(10) NOT NULL, Caracteristicas varchar(255), Descripcion varchar(255), Precio double NOT NULL, NombreProducto varchar(255), LimiteFotos int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Categoria (ID int(10) NOT NULL AUTO_INCREMENT, NombreCategoria varchar(255), Imagen varchar(255), Descripcion varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Encargado_compras (UsuarioID int(10) NOT NULL, PRIMARY KEY (UsuarioID)) ENGINE=InnoDB;
CREATE TABLE Pedido (ID int(10) NOT NULL AUTO_INCREMENT, Encargado_comprasUsuarioID int(10) NOT NULL, FechaPedido date, HoraPedido time, Pagado tinyint(1) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Oferta (ID int(10) NOT NULL AUTO_INCREMENT, PrecioOferta double NOT NULL, FechaCaducidadOferta date, Activada tinyint(1) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Cliente (UsuarioID int(10) NOT NULL, PedidoID int(10), PRIMARY KEY (UsuarioID)) ENGINE=InnoDB;
CREATE TABLE Administrador (UsuarioID int(10) NOT NULL, PRIMARY KEY (UsuarioID)) ENGINE=InnoDB;
CREATE TABLE Valoracion (ID int(10) NOT NULL AUTO_INCREMENT, ClienteUsuarioID int(10) NOT NULL, ProductoID int(10) NOT NULL, Valoracion int(10) NOT NULL, Comentario varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Usuario (ID int(10) NOT NULL AUTO_INCREMENT, Email varchar(255), Dni varchar(255), Direccion varchar(255), Nombre varchar(255), Apellidos varchar(255), Foto_perfil varchar(255), Password varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Anuncio (ID int(10) NOT NULL AUTO_INCREMENT, Encargado_comprasUsuarioID int(10) NOT NULL, TextoAnuncio varchar(255), URLimagenAnuncio varchar(255), LinkURL varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Lineas_de_Pedido (ID int(10) NOT NULL AUTO_INCREMENT, ProductoID int(10) NOT NULL, PedidoID int(10) NOT NULL, Cantidad int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Transportista (UsuarioID int(10) NOT NULL, PRIMARY KEY (UsuarioID)) ENGINE=InnoDB;
CREATE TABLE Mensaje (ID int(10) NOT NULL AUTO_INCREMENT, MensajeID int(10) NOT NULL, UsuarioID int(10) NOT NULL, IdUsuarioDestinatario int(10), IdUsuarioRemitente int(10), FechaEnvio date, HoraEnvio time, Asunto varchar(255), PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Foto (ID int(10) NOT NULL AUTO_INCREMENT, ProductoID int(10) NOT NULL, URLFoto varchar(255), IsPrincipal tinyint(1) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB;
CREATE TABLE Enviado (PedidoID int(10) NOT NULL, PRIMARY KEY (PedidoID)) ENGINE=InnoDB;
CREATE TABLE Pendiente (PedidoID int(10) NOT NULL, PRIMARY KEY (PedidoID)) ENGINE=InnoDB;
CREATE TABLE Entregado (PedidoID int(10) NOT NULL, TransportistaUsuarioID int(10) NOT NULL, PRIMARY KEY (PedidoID)) ENGINE=InnoDB;
ALTER TABLE Encargado_compras ADD CONSTRAINT FKEncargado_208625 FOREIGN KEY (UsuarioID) REFERENCES Usuario (ID);
ALTER TABLE Cliente ADD CONSTRAINT FKCliente703699 FOREIGN KEY (UsuarioID) REFERENCES Usuario (ID);
ALTER TABLE Administrador ADD CONSTRAINT FKAdministra741035 FOREIGN KEY (UsuarioID) REFERENCES Usuario (ID);
ALTER TABLE Transportista ADD CONSTRAINT FKTransporti552314 FOREIGN KEY (UsuarioID) REFERENCES Usuario (ID);
ALTER TABLE Enviado ADD CONSTRAINT FKEnviado187160 FOREIGN KEY (PedidoID) REFERENCES Pedido (ID);
ALTER TABLE Pendiente ADD CONSTRAINT FKPendiente40740 FOREIGN KEY (PedidoID) REFERENCES Pedido (ID);
ALTER TABLE Entregado ADD CONSTRAINT FKEntregado159053 FOREIGN KEY (PedidoID) REFERENCES Pedido (ID);
ALTER TABLE Valoracion ADD CONSTRAINT FKValoracion666140 FOREIGN KEY (ProductoID) REFERENCES Producto (ID);
ALTER TABLE Cliente ADD CONSTRAINT FKCliente404964 FOREIGN KEY (PedidoID) REFERENCES Pedido (ID);
ALTER TABLE Producto ADD CONSTRAINT FKProducto904736 FOREIGN KEY (CategoriaID) REFERENCES Categoria (ID);
ALTER TABLE Lineas_de_Pedido ADD CONSTRAINT FKLineas_de_374331 FOREIGN KEY (PedidoID) REFERENCES Pedido (ID);
ALTER TABLE Lineas_de_Pedido ADD CONSTRAINT FKLineas_de_617012 FOREIGN KEY (ProductoID) REFERENCES Producto (ID);
ALTER TABLE Mensaje ADD CONSTRAINT FKMensaje983572 FOREIGN KEY (UsuarioID) REFERENCES Usuario (ID);
ALTER TABLE Mensaje ADD CONSTRAINT FKMensaje450815 FOREIGN KEY (MensajeID) REFERENCES Mensaje (ID);
ALTER TABLE Pedido ADD CONSTRAINT FKPedido875184 FOREIGN KEY (Encargado_comprasUsuarioID) REFERENCES Encargado_compras (UsuarioID);
ALTER TABLE Producto ADD CONSTRAINT FKProducto444947 FOREIGN KEY (OfertaID) REFERENCES Oferta (ID);
ALTER TABLE Foto ADD CONSTRAINT FKFoto399923 FOREIGN KEY (ProductoID) REFERENCES Producto (ID);
ALTER TABLE Entregado ADD CONSTRAINT FKEntregado116749 FOREIGN KEY (TransportistaUsuarioID) REFERENCES Transportista (UsuarioID);
ALTER TABLE Valoracion ADD CONSTRAINT FKValoracion994623 FOREIGN KEY (ClienteUsuarioID) REFERENCES Cliente (UsuarioID);
ALTER TABLE Anuncio ADD CONSTRAINT FKAnuncio235124 FOREIGN KEY (Encargado_comprasUsuarioID) REFERENCES Encargado_compras (UsuarioID);
