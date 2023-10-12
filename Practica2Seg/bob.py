import funciones_rsa
import funciones_aes
import socket_class

privadaBob = funciones_rsa.cargar_RSAKey_Privada("privadaBob.txt", "Manolo")

publicaAlice = funciones_rsa.cargar_RSAKey_Publica("publicaAlice.txt")


socketserver = socket_class.SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socketserver.escuchar()
cifrado = socketserver.recibir()
firma = socketserver.recibir()

descifrado = funciones_rsa.descifrarRSA_OAEP(cifrado, privadaBob)
print(descifrado)
print(funciones_rsa.comprobarRSA_PSS(descifrado, firma, publicaAlice))


cadena = "Hola Alice"
k1 = funciones_aes.crear_AESKey()
aes_cifrado = funciones_aes.iniciarAES_CTR_cifrado(k1,cadena)


socketserver.cerrar()


