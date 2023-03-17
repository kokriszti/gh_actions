#! /usr/bin/bash

tags=($(git tag))
echo "${tags[@]}"

pattern="^([0-9]{1,3})\.([0-9]{1,3})\.([0-9]{1,3})$"
matchingTags=()
counter=0
for tag in "${tags[@]}"
do
    if [[ $tag =~ $pattern ]]
    then
        matchingTags[$counter]=$tag
        (( counter++ ))
    fi
done

echo Matching tags: "${matchingTags[@]}"

highestGitTag=0.0.0

for tag in "${matchingTags[@]}"
do
  currentMajor=$(echo $tag | cut -d"." -f1)
  currentMinor=$(echo $tag | cut -d"." -f2)
  currentPatch=$(echo $tag | cut -d"." -f3)

  highestMajor=$(echo $highestGitTag | cut -d"." -f1)
  highestMinor=$(echo $highestGitTag | cut -d"." -f2)
  highestPatch=$(echo $highestGitTag | cut -d"." -f3)
      #ha Major nagyobb, beteszi
      if [ $currentMajor -gt $highestMajor ]
      then
          highestGitTag=$tag
      #ha Major egyenlő, vizsgál Minor-t
      elif [ $currentMajor -eq $highestMajor ]
      then
        #ha Minor nagyobb, beteszi
        if [ $currentMinor -gt $highestMinor ]
        then
            highestGitTag=$tag
        #ha Minor egyenlő, vizsgál patch-t
        elif [ $currentMinor -eq $highestMinor ]
        then
            if [ $currentPatch -gt $highestPatch ]
            then
                highestGitTag=$tag
            fi
        fi
      fi
done

echo Highest git tag: "$highestGitTag"

majorFromGit=$(echo $highestGitTag | cut -d"." -f1)
minorFromGit=$(echo $highestGitTag | cut -d"." -f2)
patchFromGit=$(echo $highestGitTag | cut -d"." -f3)

versionFromFile=$(cat ../version.txt)

majorFromFile=$(echo $versionFromFile | cut -d"." -f1)
minorFromFile=$(echo $versionFromFile | cut -d"." -f2)


if [ $majorFromGit -eq $majorFromFile ] && [ $minorFromGit -eq $minorFromFile ]
then
  newPatch=$(( $patchFromGit+1 ))
  newTag=$majorFromGit.$minorFromGit.$newPatch
  echo "Matching tag found -> incrementing patch version: $newTag"
else
  newTag=$majorFromFile.$minorFromFile.0
  echo "No matching tag found -> defaulting to patch zero: $newTag"
fi

#git tag $newTag
##TODO: ha tag sikeres a runner-en, de push elhasal?
#git push origin $newTag