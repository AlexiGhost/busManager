Set /p val=Entrez le commentaire : 
git add .
git commit -m "%val%"
git pull origin master
git push origin master
PAUSE