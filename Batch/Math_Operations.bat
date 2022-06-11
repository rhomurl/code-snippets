@echo off
setlocal enabledelayedexpansion 
:mm
cls
set list[0]=[A]Add 
set list[1]=[B]Multiply 
set list[2]=[C]Divide 
set list[3]=[D]Subtract 
set list[4]=[E]Exit
for /l %%n in (0,1,4) do ( 
   echo !list[%%n]! 
)
SET /p ychoice=Select one:
if ychoice=="A" GOTO :Add
if ychoice=="B" GOTO :Multiply
if ychoice=="C" GOTO :Divide
if ychoice=="D" GOTO :Subtract
if ychoice=="E" GOTO :Exit
:Exit2
echo Exit
CLS
:Add
cls
echo Addition
SET /p add[0]=Enter first number:
SET /p add[1]=Enter second number:
SET /a sum=%add[0]%+%add[1]%
echo Sum: %sum%
set cs[0]=[1]Go back to main menu
set cs[1]=[2]Try it again
set cs[2]=[3]Exit
for /l %%z in (0,1,2) do ( 
   echo !cs[%%z]! 
)
SET /p zchoice=Select one:
if %zchoice%==1 GOTO :mm
if %zchoice%==2 GOTO :Add
if %zchoice%==3 GOTO :Exit
:Subtract
cls
echo Subtraction
SET /p sub[0]=Enter first number:
SET /p sub[1]=Enter second number:
SET /a dif=%sub[0]%-%sub[1]%
echo Difference: %dif%
set cs[0]=[1]Go back to main menu
set cs[1]=[2]Try it again
set cs[2]=[3]Exit
for /l %%z in (0,1,2) do ( 
   echo !cs[%%z]! 
)
SET /p zchoice=Select one:
if %zchoice%==1 GOTO :mm
if %zchoice%==2 GOTO :Subtract
if %zchoice%==3 GOTO :Exit
:Multiply
cls
echo Multiplication
SET /p mul[0]=Enter first number:
SET /p mul[1]=Enter second number:
SET /a pro=%mul[0]%*mul[1]%
echo Multiplication: %pro%
set cs[0]=[1]Go back to main menu
set cs[1]=[2]Try it again
set cs[2]=[3]Exit
for /l %%z in (0,1,2) do ( 
   echo !cs[%%z]! 
)
SET /p zchoice=Select one:
if %zchoice%==1 GOTO :mm
if %zchoice%==2 GOTO :Multiply
if %zchoice%==3 GOTO :Exit
:Divide
cls
echo Division
SET /p div[0]=Enter first number:
SET /p div[1]=Enter second number:
SET /a quo=%div[0]%/%div[1]%
echo Quotient: %quo%
set cs[0]=[1]Go back to main menu
set cs[1]=[2]Try it again
set cs[2]=[3]Exit
for /l %%z in (0,1,2) do ( 
   echo !cs[%%z]! 
)
SET /p zchoice=Select one:
if %zchoice%==1 GOTO :mm
if %zchoice%==2 GOTO :Divide
if %zchoice%==3 GOTO :Exit
:Exit
