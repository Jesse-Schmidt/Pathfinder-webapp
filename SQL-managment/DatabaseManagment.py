import mariadb
import sys

def setUp(cursor):
    pass

def backUp(cursor):
    pass

def main():
    # Connect to MariaDB Platform
    try:
        conn = mariadb.connect(
            user="pathfinderDB",
            password="Pathfinder",
            host="127.0.0.1",
            port=3306,
            database="PathfinderWebapp"

        )
    except mariadb.Error as e:
        print(f"Error connecting to MariaDB Platform: {e}")
        sys.exit(1)

    # Get Cursor
    myCursor = conn.cursor()

    if len(sys.argv) > 1:
        if sys.argv[1] == "setup":
            setUp(myCursor)
        if sys.argv[1] == "backup":
            backUp(myCursor)
        else:
            print("invalid arguments")
            sys.exit(1)
    else:
        print("needs arguments")
        sys.exit(1)

    conn.commit()
    conn.close()


if __name__ == "__main__":
    main()