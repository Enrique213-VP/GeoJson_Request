# 📌 GeoJSON Viewer App

Una aplicación desarrollada en **Kotlin** que consume un **GeoJSON** utilizando **Retrofit** para mostrar una lista de lugares poblados, junto con su ubicación y detalles relevantes.

## 📍 Características
- Lista de lugares con su **nombre**, **coordenadas**, **país** y si es una **capital**.
- Uso de **Retrofit** para obtener los datos desde el siguiente GeoJSON:
  - [ne_50m_populated_places_simple.geojson](https://d2ad6b4ur7yvpq.cloudfront.net/naturalearth-3.3.0/ne_50m_populated_places_simple.geojson)
- **Mapbox** para visualizar los lugares en un mapa interactivo.
- Un **AlertDialog** que muestra más información al presionar el botón de detalles.

## 🖥️ Capturas de Pantalla

### 📜 Lista de Lugares
<img src="https://raw.githubusercontent.com/Enrique213-VP/GeoJson_Request/refs/heads/main/assets/list.jpg" width="300" />

### ℹ️ Detalles de Lugar
<img src="https://raw.githubusercontent.com/Enrique213-VP/GeoJson_Request/refs/heads/main/assets/item.jpg" width="300" />

### 🗺️ Vista en Mapbox
<img src="https://github.com/Enrique213-VP/GeoJson_Request/blob/main/assets/mapbox.png" width="300" />

🔗 **Ver en Mapbox:** [Abrir Mapbox](http://geojson.io/#data=data:text/x-url,https%3A%2F%2Fd2ad6b4ur7yvpq.cloudfront.net%2Fnaturalearth-3.3.0%2Fne_50m_populated_places.geojson)

## 🚀 Tecnologías Utilizadas
- **Kotlin** - Lenguaje principal
- **Retrofit** - Para consumir la API GeoJSON
- **Gson** - Para parseo de datos
- **RecyclerView** - Para mostrar la lista de lugares
- **AlertDialog** - Para mostrar detalles
- **Mapbox** - Para visualización en el mapa

## 🛠️ Instalación y Configuración
1. Clona este repositorio:
   ```sh
   git clone https://github.com/Enrique213-VP/GeoJson_Request.git
   ```
2. Abre el proyecto en **Android Studio**.
3. Asegúrate de tener una conexión a Internet.
4. Ejecuta la aplicación en un **dispositivo o emulador**.

## 📄 Licencia
Este proyecto está bajo la licencia MIT - consulta el archivo [LICENSE](https://github.com/Enrique213-VP/GeoJson_Request/blob/main/LICENSE) para más detalles.

---

📌 **Autor:** [Svape](https://github.com/Enrique213-VP)

