package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Board b = new Board();
        String input = "", first = "", position = "";
        boolean correct = false;
        Scanner s = new Scanner(System.in);
        while (!correct) {
            boolean correct1 = false;
            while (!correct1) {
                System.out.println("White move: ");
                input = s.nextLine();
                if (input.equals("X")) {
                    correct1 = true;
                    correct = true;
                } else if (input.length() == 3) {
                    first = Character.toString(input.charAt(0));
                    if ("KQRBN".contains(first)) {
                        position = Character.toString(input.charAt(1)) + Character.toString(input.charAt(2));
                        if (first.equals("K")) {
                            try {
                                b.move(King.class, ChessPiece.Color.WHITE, position);
                                if (b.isCheck(ChessPiece.Color.BLACK))
                                    System.out.println("CHECK!!!");
                                correct1 = true;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (first.equals("Q")) {
                            try {
                                b.move(Queen.class, ChessPiece.Color.WHITE, position);
                                if (b.isCheck(ChessPiece.Color.BLACK))
                                    System.out.println("CHECK!!!");
                                correct1 = true;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (first.equals("R")) {
                            try {
                                b.move(Rook.class, ChessPiece.Color.WHITE, position);
                                if (b.isCheck(ChessPiece.Color.BLACK))
                                    System.out.println("CHECK!!!");
                                correct1 = true;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (first.equals("B")) {
                            try {
                                b.move(Bishop.class, ChessPiece.Color.WHITE, position);
                                if (b.isCheck(ChessPiece.Color.BLACK))
                                    System.out.println("CHECK!!!");
                                correct1 = true;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (first.equals("N")) {
                            try {
                                b.move(Knight.class, ChessPiece.Color.WHITE, position);
                                if (b.isCheck(ChessPiece.Color.BLACK))
                                    System.out.println("CHECK!!!");
                                correct1 = true;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else System.out.println("Illegal move.");
                } else if (input.length() == 2) {
                    try {
                        b.move(Pawn.class, ChessPiece.Color.WHITE, input);
                        if (b.isCheck(ChessPiece.Color.BLACK))
                            System.out.println("CHECK!!!");
                        correct1 = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Illegal move.");
                }
            }
            if (!correct) {
                boolean correct2 = false;
                while (!correct2) {
                    System.out.println("Black move: ");
                    input = s.nextLine();
                    if (input.equals("X")) {
                        correct2 = true;
                        correct = true;
                    } else if (input.length() == 3) {
                        first = Character.toString(input.charAt(0));
                        if ("KQRBN".contains(first)) {
                            position = Character.toString(input.charAt(1)) + Character.toString(input.charAt(2));
                            if (first.equals("K")) {
                                try {
                                    b.move(King.class, ChessPiece.Color.BLACK, position);
                                    if (b.isCheck(ChessPiece.Color.WHITE))
                                        System.out.println("CHECK!!!");
                                    correct2 = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (first.equals("Q")) {
                                try {
                                    b.move(Queen.class, ChessPiece.Color.BLACK, position);
                                    if (b.isCheck(ChessPiece.Color.WHITE))
                                        System.out.println("CHECK!!!");
                                    correct2 = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (first.equals("R")) {
                                try {
                                    b.move(Rook.class, ChessPiece.Color.BLACK, position);
                                    if (b.isCheck(ChessPiece.Color.WHITE))
                                        System.out.println("CHECK!!!");
                                    correct2 = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (first.equals("B")) {
                                try {
                                    b.move(Bishop.class, ChessPiece.Color.BLACK, position);
                                    if (b.isCheck(ChessPiece.Color.WHITE))
                                        System.out.println("CHECK!!!");
                                    correct2 = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (first.equals("N")) {
                                try {
                                    b.move(Knight.class, ChessPiece.Color.BLACK, position);
                                    if (b.isCheck(ChessPiece.Color.WHITE))
                                        System.out.println("CHECK!!!");
                                    correct2 = true;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        } else System.out.println("Illegal move.");
                    } else if (input.length() == 2) {
                        try {
                            b.move(Pawn.class, ChessPiece.Color.BLACK, input);
                            if (b.isCheck(ChessPiece.Color.WHITE))
                                System.out.println("CHECK!!!");
                            correct2 = true;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Illegal move.");
                    }
                }
            }
        }
    }
}