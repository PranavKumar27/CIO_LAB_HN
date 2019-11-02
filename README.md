# CIO_LAB_HN
CIO lab devices Scan Application using Servlets


This application will cater the scan and flashing of all CEP based devices in 11.1.205.X network

Initial Reqirement

1. On a web hosted URL provide Index no and select F/W file to upgrade the F/W.

Advantage:

1. Everytime we build F/W we have to copy F/W built from DEV1 to testbed 11.1.205.X VM's.
2. Connect to devices UOC/CN100 using WinSCP and then copy the file using SSH in /tmp
3. Run upgrade.sh && reboot.

This project will eliminate these intermediate steps fully.


Initial Design

User inputs index and select F/W file and clicks on Flash button on web page.
This webpage URI is accessible everywhere in the HON network. 
The initial phase testing URL is http://10.79.215.150:443/CIO_LAB

Initial Bugs

File object selected in not released hence UOC build is failing
Progress BAR required as file upload is taking time and user is not updated.
Can we restore the last selected file by the user. Everytime page refresh occurs we loose track of previous form data.


