# Swing P02

## Descripción del proyecto

**CompraProductosModificado** es una aplicación gráfica desarrollada en Java utilizando Swing. 
Esta herramienta permite gestionar compras de productos navideños mediante una interfaz intuitiva que incluye funciones como agregar productos al carrito, eliminar artículos seleccionados y capturar información del usuario.

## Contenido de la publicación

La aplicación incluye las siguientes funcionalidades principales:

**Gestión de compras:**
  - Selección de productos desde un menú desplegable.
  - Agregar productos al carrito con detalles de cantidad y precio.
  - Eliminar artículos seleccionados del carrito.
  
**Captura de datos personales:**
  - Formulario para ingresar datos como DNI, nombre, apellidos, dirección, y código postal.

**Visualización de imágenes:**
  - Imágenes asociadas a cada producto, con una opción para mostrarlas u ocultarlas desde el menú.

## Desarrollo del proyecto

El proyecto utiliza componentes y clases de Swing para proporcionar una experiencia de usuario gráfica e interactiva.  
Se ha incorporado validación para las entradas de datos y soporte para diversas funcionalidades interactivas, como el manejo de eventos y operaciones en tablas.

### Estructura principal:

- **Ventana principal:** Un `JDialog` que organiza los componentes de la interfaz.
- **Gestión de tablas:** Uso de `DefaultTableModel` para mostrar productos y cantidades de forma no editable.
- **Eventos:** Listeners para manejar acciones de botones y menús desplegables.
- **Imágenes:** Carga de recursos gráficos mediante `ImageIcon`.

## Despliegue

### Cómo ejecutar la aplicación desde el ejecutable

1. Asegúrate de tener instalado Java Runtime Environment (JRE) en tu sistema.
2. Navega a la carpeta que contiene el archivo `.jar` de la aplicación.
3. Ejecuta el archivo con el siguiente comando:
   java -jar CompraProductosModificado.jar
