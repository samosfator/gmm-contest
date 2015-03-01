package ua.samosfator.stat.parser.statistic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimePeriodStatsPiecesParser {

    private List<String> statsPieces;

    public TimePeriodStatsPiecesParser(List<String> statsPieces) {
        this.statsPieces = statsPieces;
    }

    public int parseIntPiece(String pieceName) {
        if (statsPieces.size() < 1) return 0;
        if (statsPieces.toString().contains(pieceName)) {
            String pieceStr = getPieceStr(pieceName);

            Pattern regex = Pattern.compile("\\d+");
            Matcher matcher = regex.matcher(pieceStr);

            if (matcher.find()) {
                String daysStr = matcher.group().trim();
                try {
                    return Integer.parseInt(daysStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public double parseDoublePiece(String pieceName) {
        if (statsPieces.size() < 1) return 0;
        if (statsPieces.toString().contains(pieceName)) {
            String pieceStr = getPieceStr(pieceName);

            Pattern regex = Pattern.compile("\\d+.\\d+");
            Matcher matcher = regex.matcher(pieceStr);

            if (matcher.find()) {
                String daysStr = matcher.group().trim();
                try {
                    return Double.parseDouble(daysStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    private String getPieceStr(String pieceName) {
        int pieceIndex = 0;
        boolean pieceFound = false;

        for (int i = 0; i < statsPieces.size(); i++) {
            String statsPiece = statsPieces.get(i);
            if (statsPiece.contains(pieceName)) {
                pieceIndex = i;
                pieceFound = true;
            }
        }

        if (pieceFound) {
            return statsPieces.get(pieceIndex).trim();
        } else {
            return "";
        }
    }
}
