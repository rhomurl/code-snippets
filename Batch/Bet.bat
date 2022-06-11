@echo off
::1. The program will use random function (1-13)
::2. User and computer have 5k pesos
::3. Compare the number of user and computer and will show win or lose
::4. Display the result and the updated money of user and computer
::Random things
::Set both money
SET /a umoney=5000
SET /a cmoney=5000
GOTO START
:START
if %umoney% LEQ 0 GOTO lose
if %cmoney% LEQ 0 GOTO lose
SET /a uran=%RANDOM% %%13+1
SET /a cran=%RANDOM% %%13+1
echo User's money: %umoney%
echo Computer: %cmoney%
echo. 
SET /p bet=Enter bet:
echo The user's number is: %uran%
echo The computer's number is: %cran%
echo. 
GOTO cond
::compare nummy
:cond
if %uran% GTR %cran% ( 
SET /a pp=1
GOTO res
)
if %uran% LSS %cran% ( 
SET /a pp=2
GOTO res
)
if %uran% EQU %cran% ( 
SET /a pp=3
GOTO res
)
:res
if %pp% EQU 1 (
SET /a umoney=%umoney%+%bet%
SET /a cmoney=%cmoney%-%bet%
echo Player won!
echo ----------------------------------------
GOTO START
)
if %pp% EQU 2 (
SET /a umoney=%umoney%-%bet%
SET /a cmoney=%cmoney%+%bet%
echo Computer won!
echo ----------------------------------------
GOTO START
)
if %pp% EQU 3 (
echo Draw!
echo ----------------------------------------
GOTO START
)
:lose
if %umoney% LEQ 0 (
echo User's money: %umoney%
echo Computer: %cmoney%
echo User lose! )
if %cmoney% LEQ 0 ( 
echo User's money: %umoney%
echo Computer: %cmoney%
echo Computer lose! )
​
