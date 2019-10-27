# Dominio
https://en.m.wikipedia.org/wiki/English_draughts


# 1.ADCS.pruebas

- Diseño Modelo/Vista/Controlador con Presentador del Modelo/Vista/Controlador
@startuml Checkers

class Checkers {
+ play()
}
Checkers *-down-> Logic
Checkers *-down-> View

class View {
+ interact(Contorller)
}

class StartView #orange {
+ interact(StartController)
}

class PlayView  #orange {
+ interact(PllayController)
}

class ResumeView  #orange {
+ interact(ResumeController)
}

StartView ..> StartController
PlayView ..> PlayController
ResumeView ..> ResumeController

View *-down-> StartView
View *-down-> PlayView
View *-down-> ResumeView
StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView ..> PieceView

View ..> AcceptController

class Logic{
+ getController()
}
Logic *--> State
Logic *--> Game
Logic *-down-> AcceptController

class Controller{
}

class AcceptController{
}

Controller <|-down- AcceptController
AcceptController <|-down- StartController
AcceptController <|-down- PlayController
Controller <|-down- MoveController
Controller <|-down- CancelController
AcceptController <|-down- ResumeController
Controller o--> Game

class StartController{
  + start()
}

class MoveController{
+ Error move(Coordinate origin, Coordinate target)
+ getPiece(Coordinate origin)
+ Color getWinner()
+ Color getTurn()
}

class CancelController{
+ cancel()
}

class ResumeController{
  + resume(boolean newGame) 
}

class PlayController{
+ Error move(Coordinate origin, Coordinate target)
+ getPiece(Coordinate origin)
+ Color getWinner()
+ cancel()
+ Color getTurn()
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
+ move(Coordinate origin, Coordinate target)
+ getPiece(Coordinate origin)
+ Color getWinner()
}
Game *-down-> Board
Game *-down-> Color
Game ..> Error

class Board{
+ Integer distanceInDiagonal(Coordinate square, Coordinate square2)
+ put(Coordinate square, Piece piece)
+ clean(Coordinate square)
}
Board *-down-> "1..2x12" Piece
Board ..> Error


class Piece{
}
Piece <|-down- Peon
Piece <|-down- Dama
Piece *--> Color 

class Men{
}

class King{
}

class Color{
}

class State{
+ next()
+ reset()
+ StateValue getValueState()
}

class Error{
}
@enduml
