# MESS-Modified-chESS

I am just creating a toy chess program that lets me set up pieces on a chessboard, move them, and find possible moves for a given piece in a certain position. This is my 1st assignment for my Software Product and Process Evaluation (CS514) class at CSU.


The rules are simplified as follows:

- Assume that the queen and knight can't move.
- The king can only move one square horizontally, vertically, or diagonally. Assume that it cannot castle.
- A pawn in the initial position may move one or two squares vertically forward to an empty square but cannot leap over any piece. Subsequently it can move only one square vertically forward to an empty square. A pawn may also capture (replace) an opponent's piece diagonally one square in front of it. Pawns can never move backwards. These are the only moves; we will not implement the En passant rule and will also not allow promotion to another piece if the pawn reaches the end of the column. If you don't know what these rules are, don't worry. We won't use them.
- A rook can move any number of squares horizontally or vertically, forward or backward, as long as it does not have to leap over other pieces. At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece but it cannot replace another piece of the same player.
- A bishop can move any number of squares diagonally in any direction as long as it does not have to leap over other pieces. At the end of the move, it can occupy a previously empty square or capture (replace) an opponent's piece but it cannot replace another piece of the same player.
