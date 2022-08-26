from pkg import Ponto2D, Reta, EspacoGeometrico, ObjetoSobrepostoException

esp = EspacoGeometrico()

retaVermelha = Reta(1, 2)
retaVerde = Reta(1, 1)
retaAzul = Reta(2, -2)

pontoA = Ponto2D(3, 4)
pontoB = Ponto2D(2, 3)
pontoC = Ponto2D(4, 6)

def adicionarReta(reta, nomeReta):
  try:
    esp.adicionarReta(reta)
    print(f"A reta {nomeReta} foi adicionada com sucesso.")
  except ObjetoSobrepostoException as e:
    print(f"A reta {nomeReta} não pôde ser adicionada porque sobrepõe outras retas existentes.")

def adicionarPonto(ponto, nomePonto):
  try:
    esp.adicionarPonto(ponto)
    print(f"O ponto {nomePonto} foi adicionado com sucesso")
  except ObjetoSobrepostoException as e:
    print(f"O ponto {nomePonto} não pôde ser adicionado porque ele pertence à uma reta.")

adicionarReta(retaVermelha, "vermelha")
adicionarReta(retaVerde, "verde")
adicionarReta(retaAzul, "azul")

adicionarPonto(pontoA, "A")
adicionarPonto(pontoB, "B")
adicionarPonto(pontoC, "C")


