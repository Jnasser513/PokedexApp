# 📱 PokedexApp

Aplicación Android desarrollada en Kotlin que permite explorar información de Pokémon utilizando la [PokeAPI](https://pokeapi.co/). Está construida con Jetpack Compose y una arquitectura moderna basada en Clean Architecture, MVI, modularización y estrategia offline-first.

---

## 🚀 Tecnologías y arquitectura

- **Kotlin**
- **Jetpack Compose**
- **Clean Architecture** – Separación por capas (Domain, Data, Presentation)
- **MVI (Model-View-Intent)** – Patrón unidireccional para gestión de estados
- **Arquitectura Modular** – Separación en módulos independientes y escalables
- **Offline First** – Persistencia local para trabajar sin conexión

### Librerías utilizadas

- **Koin** – Inyección de dependencias
- **Ktor Client** – Cliente HTTP asíncrono
- **Coil** – Carga de imágenes optimizada para Compose
- **Kotlin Coroutines + Flow** – Programación asíncrona y reactiva

---

## 🛠️ ¿Cómo correr este proyecto?

### 1. Clonar el repositorio

```bash
git clone https://github.com/Jnasser513/PokedexApp.git
```

### 2. Abrir el proyecto en Android Studio

1. Abre **Android Studio**.
2. Selecciona **File > Open**.
3. Navega a la carpeta donde se clono el proyecto y haz clic en **Open**.
4. Espera a que finalice la sincronización de Gradle (puede tardar unos segundos).

### 3. Configurar un emulador o dispositivo

- Abre el **AVD Manager** y lanza un emulador (API 24 o superior), o conecta un dispositivo Android con **Depuración USB** activada.

### 4. Ejecutar la aplicación

- Haz clic en el botón **Run ▶️** en la barra superior de Android Studio.
- Selecciona el dispositivo donde deseas ejecutar la app.
- La aplicación debería ejecutarse correctamente.

---

## ✅ Requisitos
- SDK mínimo: API 24 (Android 7.0)
- Conexión a Internet (la app consume datos de una API en línea la primera vez)

---

## 🧱 Estructura del proyecto

Este proyecto sigue los principios de Clean Architecture, está organizado de forma modular y con una estrategia de offline first para poder utilizar la aplicacion en modo offline si los datos ya fueron almacenados almenos 1 vez.

