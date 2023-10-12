import funciones_rsa
import funciones_aes
import socket_class

privadaAlice = funciones_rsa.cargar_RSAKey_Privada("privadaAlice.txt", "Manolo")

publicaBob = funciones_rsa.cargar_RSAKey_Publica("publicaBob.txt")

k1 = funciones_aes.crear_AESKey()

cifradoPub = funciones_rsa.cifrarRSA_OAEP(k1, publicaBob)

firma = funciones_rsa.firmarRSA_PSS(k1, privadaAlice)

socketclient = socket_class.SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socketclient.conectar()
socketclient.enviar(cifradoPub)
socketclient.enviar(firma)

socketclient.cerrar()


