## Descargar el Proyecto

### Pasos para clonar o actualizar (git pull) el repositorio y ejecutar el proyecto en IntelliJ IDEA

1. **Instalar Git en caso de no tenerlo:**
   - Asegúrate de tener Git instalado en tu máquina. Puedes descargarlo e instalarlo desde [git-scm.com](https://git-scm.com/).

#### Nota: Si no tienes el repositorio en tu maquina clonalo con el paso 2, si aun tienes el repositorio en tu maquina ve al paso 3 para hacer un git pull (traer los nuevos cambios realizados/actualizaciones en el repositorio).

2. **Clonar el repositorio (Si no lo tienes en tu máquina):**
   - Abre una terminal o línea de comandos.
   - Navega al directorio donde deseas clonar el proyecto.
   - Ejecuta el siguiente comando para clonar el repositorio:
     ```sh
     git clone git@github.com:ipvan2000/JavaExercises.git
     ```

3. **Actualizar el repositorio existente (Si ya lo tienes en tu máquina):**
   - Abre una terminal o línea de comandos.
   - Navega al directorio donde tienes clonado el repositorio.
   - Ejecuta el siguiente comando para actualizar el repositorio con los últimos cambios:
     ```sh
     git pull
     ```

3. **Abrir el proyecto en IntelliJ IDEA:**
   - Abre IntelliJ IDEA.
   - Selecciona `File` > `Open...` y navega hasta el directorio donde clonaste el repositorio.
   - Selecciona la carpeta del proyecto y haz clic en `OK`.

5. **Configurar el SDK de Java:**
   - Asegúrate de tener configurado el SDK de Java en IntelliJ IDEA.
   - Ve a `File` > `Project Structure...` > `Project` y selecciona el SDK de Java adecuado.

6. **Ejecutar el proyecto:**
   - Navega hasta el archivo `Main.java` en el panel del proyecto.
   - Haz clic derecho en `Main.java` y selecciona `Run 'Main.main()'`.
   - El proyecto se compilará y ejecutará, mostrando la salida en la consola de IntelliJ IDEA.

### Notas adicionales

- Si encuentras algún problema al ejecutar el proyecto, revisa la configuración del SDK y las dependencias del proyecto.
Siguiendo estos pasos, deberías poder clonar el repositorio y ejecutar el proyecto en IntelliJ IDEA sin problemas.