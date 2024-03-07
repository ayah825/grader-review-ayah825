CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

# more comments pls
# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if [[ -f student-submission/ListExamples.java ]] 
then 
    cp student-submission/ListExamples.java grading-area/
    echo "File Found"
else 
    echo "File ListExamples.java not found"
    exit 1
fi


cp -r lib grading-area/

cp TestListExamples.java grading-area/

cd grading-area

javac -cp $CPATH *.java

if [[ $? -ne 0 ]] 
then 
    echo "The program failed to complile"
    exit 1
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > test-output.txt

TESTRESULTS=$(cat test-output.txt | tail -n 2 | head -n 1)

if [[ $(echo $TESTRESULTS | awk -F '[ ]'  '{print $1}') == 'OK' ]]
then
    TESTSRUN=$(echo $TESTRESULTS | awk -F '[( ]'  '{print $3}')
    FAILURES=0
else
    TESTSRUN=$(echo $TESTRESULTS | awk -F '[, ]'  '{print $3}')
    FAILURES=$(echo $TESTRESULTS | awk -F '[, ]'  '{print $6}')
fi

SUCSESS=$(( TESTSRUN - FAILURES ))

echo "Your score is: $SUCSESS / $TESTSRUN "
