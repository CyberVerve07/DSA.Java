git config --local user.name "CyberVerve07"
git config --local user.email "adityamahajan7287@gmail.com"
git reset --soft HEAD~1
git commit -m "Add Problem5: Valid Parentheses" --author="CyberVerve07 <adityamahajan7287@gmail.com>"
git push -f origin master
git log -1 --format="%%an <%%ae> %%s" > git_verify.txt
