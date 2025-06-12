; -- Configuración del Instalador --

[Setup]
AppName=ProyectoFinal
AppVersion=1.0
ArchitecturesInstallIn64BitMode=x64compatible
DefaultDirName={commonpf64}\ProyectoFinal
DefaultGroupName=ProyectoFinal
UninstallDisplayIcon={app}\ProyectoFinal.ico
OutputDir=.
OutputBaseFilename=ProyectoFinal_Setup
Compression=lzma2
SolidCompression=yes

; -- Archivos a incluir --

[Files]
Source: "ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"; DestDir: "{app}"; Flags: ignoreversion

; -- Crear accesos directos en el grupo de inicio y en el escritorio --

[Icons]
Name: "{group}\ProyectoFinal"; Filename: "javaw.exe"; Parameters: "-jar ""{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"""; WorkingDir: "{app}"; IconFilename: "{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"
Name: "{commondesktop}\ProyectoFinal"; Filename: "javaw.exe"; Parameters: "-jar ""{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"""; WorkingDir: "{app}"; IconFilename: "{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"

; -- Ejecutar el JAR tras instalación --

[Run]
Filename: "javaw.exe"; Parameters: "-jar ""{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"""; WorkingDir: "{app}"; Flags: nowait postinstall skipifsilent

; -- Limpieza en desinstalación --

[UninstallDelete]
Type: files; Name: "{app}\ProyectoFinal-1.0-SNAPSHOT-jar-with-dependencies.jar"
