import math
import sys

#TODO zaimportuj moduł pygame i utwórz ekran (zmienna screen) o wymiarach 1200x600, ustaw także tytuł ekranu "JPWP-project"
import pygame
pygame.init() # inicjalizacja modułu
SCREEN_WIDTH = 1200
SCREEN_HEIGHT = 600
screen = pygame.display.set_mode( (SCREEN_WIDTH, SCREEN_HEIGHT) )

screen_CENTER = 600, 300

class Player(object):

    def __init__(self):
        self.x, self.y = screen_CENTER
        self.surface = pygame.image.load('player&hand.png')
        #TODO Skopiuj obrazek do zmiennej rotated_surface
        self.rotated_surface = self.surface.copy()

        self.rect = self.surface.get_rect()
        self.speed = 0.4

    def rotate(self, angle):
        self.rotated_surface = pygame.transform.rotate(self.surface, angle)
        self.rect = self.rotated_surface.get_rect(center=screen.get_rect().center)

    def draw(self):
        #TODO Uzupełnij funkcję blit
        # drugi argument, to przybliżanie prostokątem, ustawienie środka postaci na środek okna
        screen.blit(self.rotated_surface,
         self.rotated_surface.get_rect(center=(self.x, self.y)))

player1 = Player()

running = True

def redraw():
    screen.fill((0, 0, 0))
    # TODO uzupełnij funkcję redraw w celu usunięcia efekty zostawiania "śladu" przy przesuwaniu graczem
    player1.draw()
    pygame.display.flip()
    pygame.display.update()


while (running):
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            sys.exit()
        elif e.type == pygame.KEYDOWN:
    #TODO ustaw wyłączanie gry za pomocą przycisku Esc
            if e.key == pygame.K_ESCAPE:
                running = False

    keys = pygame.key.get_pressed()

    # Lewy górny róg okna to współrzędne (0,0)
    if keys[pygame.K_a]: # LEWO 
        player1.x -= player1.speed
    #TODO Dopisz kolejne ify sprawdzające czy czy użytkownik nacisnął klawisze: W, S, D oraz podaj instrukcje, które określają sposób poruszania się gracza
    if keys[pygame.K_d]: # PRAWO  x+
        player1.x += player1.speed
    if keys[pygame.K_w]: # GÓRA y+ 
        player1.y -= player1.speed
    if keys[pygame.K_s]: # DÓŁ y+
        player1.y += player1.speed

    elif e.type == pygame.MOUSEMOTION:

    #TODO Do zmiennych mouse_x i mouse_y przypisz aktualną pozycję kursora myszki. Określamy kąt pomiędzy odpowiednimi punktami (funkcja atan2), pamiętaj w jakich wartościach atan2 zwraca wynik
        mouse_x, mouse_y = pygame.mouse.get_pos()
        angle = math.atan2(mouse_x - player1.x, mouse_y - player1.y)
        # angle mamy w radianach, dlatego nalezy zmienić na stopnie oraz dodać 180 by przejść na zakres (0,360) dla funkcji rotate
        angle = math.degrees(angle) + 180
        player1.rotate(angle)

    redraw()
pygame.quit()
