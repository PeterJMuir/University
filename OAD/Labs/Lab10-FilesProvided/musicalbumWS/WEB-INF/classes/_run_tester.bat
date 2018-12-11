REM Use the next command IF MySQL driver jar file is in it directory
REM java -cp ".;*" MusicAlbumDSCTester

REM Use the following command IF jar files is in lib directory
java -cp ".;..\lib\*;%CLASSPATH%" MusicAlbumDSCTester
pause