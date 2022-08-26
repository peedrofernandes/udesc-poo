from operator import truediv


class Ponto2D:
  def __init__(self, x, y):
    self.x = x
    self.y = y


class Reta:
  def __init__(self, a, b):
    self.a = a
    self.b = b
  
  def intercepta(self, reta):
    if (self.a == reta.a):
      return False
    else:
      return True

  def estaNaReta(self, ponto):
    if (ponto.y == self.a * ponto.x + self.b):
      return True
    else:
      return False


class EspacoGeometrico:
  def __init__(self):
    self.pontos = []
    self.retas = []

  def adicionarReta(self, reta):
    for r in self.retas:
      if (r.intercepta(reta)):
        raise ObjetoSobrepostoException()
    self.retas.append(reta)
    
  
  def adicionarPonto(self, ponto):
    for r in self.retas:
      if (r.estaNaReta(ponto)):
        raise ObjetoSobrepostoException()
    self.pontos.append(ponto)


class ObjetoSobrepostoException(Exception):
  def __init__(self):
    super().__init__()