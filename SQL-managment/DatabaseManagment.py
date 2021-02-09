import mariadb
import sys
import os

def setUp(cursor):
    createTableString = "CREATE TABLE IF NOT EXISTS "
    for file in os.listdir():
        if os.path.isfile(file) and file[len(file)-3:] == "txt":
            print (createTableString + file[0: len(file)-4])

def backUp(cursor):
    pass

def main():
    # Connect to MariaDB Platform
    try:
        conn = mariadb.connect(
            user="PathfinderDB",
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