import funciones_rsa

def clavesAlice():
    parPubPrivAlice = funciones_rsa.crear_RSAKey()
    funciones_rsa.guardar_RSAKey_Privada("privadaAlice.txt", parPubPrivAlice, "Manolo")
    funciones_rsa.guardar_RSAKey_Publica("publicaAlice.txt", parPubPrivAlice)

def clavesBob():
    parPubPrivBob = funciones_rsa.crear_RSAKey()
    funciones_rsa.guardar_RSAKey_Privada("privadaBob.txt", parPubPrivBob, "Manolo")
    funciones_rsa.guardar_RSAKey_Publica("publicaBob.txt", parPubPrivBob)

def main():
    clavesAlice()
    clavesBob()
    print("Se han generado y guardado las claves de Alice y Bob.")

if __name__ == "__main__":
    main()

