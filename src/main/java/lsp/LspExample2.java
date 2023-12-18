package lsp;

public class LspExample2 {

    public static class Database {

        public void Connect() {
        }
        public void Read() {
        }
        public void Write() {
        }

        public void JoinTables() {
        }
    }

    public static class MySqlDB extends Database {
    }

    public static class MongoDB extends Database {
    }
}
