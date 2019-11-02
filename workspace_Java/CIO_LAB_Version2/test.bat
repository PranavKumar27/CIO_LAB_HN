set HOST_IP=%1
set FILE_NAME=%2


scp -o "StrictHostKeyChecking no" C:\temp\%HOST_IP%\%FILE_NAME% root@%HOST_IP%:/tmp/%FILE_NAME% >> C:\temp\%HOST_IP%\output1.txt 2>&1

ssh -o "StrictHostKeyChecking no" root@%HOST_IP% HONEYWELL_APP_DIR=/usr/honeywell PATH=$PATH:/usr/honeywell/bin "date && ps && sleep 50s" >> C:\temp\%HOST_IP%\output2.txt 2>&1

rem @RD /S /Q "C:\temp\%HOST_IP%"