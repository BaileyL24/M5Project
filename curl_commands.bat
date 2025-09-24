@echo off

REM ===== Create a User =====
echo --- Creating User ---
curl -s -X POST http://localhost:8080/users ^
  -H "Content-Type:application/json" ^
  -d "{\"username\":\"john_doe\",\"password\":\"secret123\"}"
echo.

REM ===== Create a Task =====
echo --- Creating Task ---
curl -s -X POST http://localhost:8080/tasks ^
  -H "Content-Type:application/json" ^
  -d "{\"title\":\"Sample Task\",\"description\":\"A task description\",\"status\":\"pending\",\"dueDate\":\"2024-12-31\"}"
echo.

REM ===== Create a Subtask (DTO with taskId) =====
echo --- Creating Subtask ---
curl -s -X POST http://localhost:8080/subtasks ^
  -H "Content-Type:application/json" ^
  -d "{\"title\":\"Subtask 1\",\"status\":\"IN_PROGRESS\",\"taskId\":1}"
echo.

REM ===== Update the Subtask (DTO with taskId) =====
echo --- Updating Subtask ---
REM Replace {id} with the subtask's actual ID (likely 1 if this is the first one created)
curl -s -X PUT http://localhost:8080/subtasks/1 ^
  -H "Content-Type:application/json" ^
  -d "{\"title\":\"Updated Subtask\",\"status\":\"PENDING\",\"taskId\":1}"
echo.

REM ===== Associate the Task with the User =====
echo --- Associating Task with User ---
curl -s -X POST http://localhost:8080/tasks/1/users/1
echo.

REM ===== Display the User with Associated Task Titles =====
echo --- Displaying User (with associated task titles) ---
curl -s http://localhost:8080/users/1
echo.

REM ===== Display the Task with Associated Usernames =====
echo --- Displaying Task (with associated usernames) ---
curl -s http://localhost:8080/tasks/1
echo.
