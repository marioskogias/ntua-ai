:- dynamic(has/1).
:- dynamic(has_not/1).

start:- write('Welcome to the automated system of nursing. Please answer the following questions properly and pres dot\n'),
	diagnosis(X),
	write('You probably have '),
	write(X),!.

start:- write('No idea').



% diagnose a Cold

diagnosis(cold) :- symptom(sore_throat),
		symptom(fever),
		symptom(cough),
		symptom(short_period_symptoms).

%Symptoms

symptom(fever) :- has(fever),!.
symptom(fever) :- \+ has_not(fever), write('Do you  have a fever (y/n) ?'),
			read(Reply),addKnowledge(fever,Reply),
			Reply='y'.


symptom(sore_throat) :- has(sore_throat),!.
symptom(sore_throat) :- \+ has_not(sore_throat), write('Do you  have a sore throat (y/n) ?'),
			read(Reply),addKnowledge(sore_throat,Reply),
			Reply='y'.

symptom(cough) :- has(cough),!.
symptom(cough) :- \+ has_not(sore_throat), write('Do you  have cough (y/n) ?'),
			read(Reply),addKnowledge(fever,Reply),
			Reply='y'.

symptom(short_period_symptoms) :- has(short_period_symptoms),!.
symptom(short_period_symptoms) :- \+ has_not(short_period_symptoms), write('Do you have these symptoms for less than a week (y/n) ?'),
				read(Reply),addKnowledge(fever,Reply),
				Reply='y'.

addKnowledge(Cause,'y') :- asserta(has(Cause)).
addKnowledge(Cause,'n') :- asserta(has_not(Cause)).

