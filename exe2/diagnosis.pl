:- dynamic(has/1).
:- dynamic(has_not/1).

start:- write('Welcome to the automated system of nursing. Please answer the following questions properly and pres dot\n'),
	diagnosis(X),
	write('You probably have '),
	write(X),!.

start:- write('The automated system can\'t figure out what is your problem. You are suggested to visit a human doctor\n').



% diagnose a Cold

diagnosis(cold) :- symptom(sore_throat),
		symptom(cough),
		symptom(tired),
		symptom(headache),
		symptom(short_period_symptoms).

% diagnose a flu

diagnosis(flu) :- symptom(sore_throat),
			symptom(fever),
			symptom(nausia_vomit),
			symptom(feeling_cold),
			symptom(headache),
			symptom(sneeze),
			symptom(red_eyes).

% diagnose minigitis

diagnosis(minigitis) :- symptom(headache),
			symptom(stiff),
			symptom(fever),
			symptom(sudden_fever),
			symptom(mood),
			symptom(photophobia).
%Symptoms

symptom(fever) :- has(fever),!.
symptom(fever) :- \+ has_not(fever), write('Do you have a fever (y/n) ?'),
			read(Reply),addKnowledge(fever,Reply),
			Reply='y'.

symptom(stiff) :- has(stiff),!.
symptom(stiff) :- \+ has_not(stiff), write('Do you feel your neck stiff (y/n) ?'),
			read(Reply),addKnowledge(stiff,Reply),
			Reply='y'.

symptom(sudden_fever) :- has(sudden_fever),!.
symptom(sudden_fever) :- \+ has_not(sudden_fever), write('Was your fever sudden and high (y/n) ?'),
			read(Reply),addKnowledge(sudden_fever,Reply),
			Reply='y'.

symptom(mood) :- has(mood),!.
symptom(mood) :- \+ has_not(mood), write('Do you think your mood has changed recently y/n) ?'),
			read(Reply),addKnowledge(mood,Reply),
			Reply='y'.
			
symptom(photophobia) :- has(phoyophobia),!.
symptom(photophobia) :- \+ has_not(photophobia), write('Are you afraid of light recently (y/n) ?'),
			read(Reply),addKnowledge(photophobia,Reply),
			Reply='y'.

symptom(sneeze) :- has(sneeze),!.
symptom(sneeze) :- \+ has_not(sneeze), write('Do you sneeze a lot (y/n) ?'),
			read(Reply),addKnowledge(sneeze,Reply),
			Reply='y'.

symptom(red_eyes) :- has(red_eyes),!.
symptom(red_eyes) :- \+ has_not(red_eyes), write('Are your eyes redish (y/n) ?'),
			read(Reply),addKnowledge(red_eyes,Reply),
			Reply='y'.

symptom(feeling_cold) :- has(feeling_cold),!.
symptom(feeling_cold) :- \+ has_not(feeling_cold), write('Do you often feel cold (y/n) ?'),
			read(Reply),addKnowledge(feeling_cold,Reply),
			Reply='y'.

symptom(headache) :- has(headache),!.
symptom(headache) :- \+ has_not(headache), write('Do you have a head-ache (y/n) ?'),
			read(Reply),addKnowledge(headache,Reply),
			Reply='y'.

symptom(sore_throat) :- has(sore_throat),!.
symptom(sore_throat) :- \+ has_not(sore_throat), write('Do you  have a sore throat (y/n) ?'),
			read(Reply),addKnowledge(sore_throat,Reply),
			Reply='y'.

symptom(cough) :- has(cough),!.
symptom(cough) :- \+ has_not(sore_throat), write('Do you  have cough (y/n) ?'),
			read(Reply),addKnowledge(cough,Reply),
			Reply='y'.

symptom(short_period_symptoms) :- has(short_period_symptoms),!.
symptom(short_period_symptoms) :- \+ has_not(short_period_symptoms), write('Do you have these symptoms for less than a week (y/n) ?'),
				read(Reply),addKnowledge(short_period_sympotoms,Reply),
				Reply='y'.


symptom(tired) :- has(tired),!.
symptom(tired) :- \+ has_not(tired), write('Do you feel tired (y/n) ?'),
			read(Reply),addKnowledge(tired,Reply),
			Reply='y'.

symptom(nausia_vomit) :- has(nausia_vomit),!.
symptom(nausia_vomit) :- \+ has_not(nausia_vomit), write('Do you often feel nausia and vomit (y/n) ?'),
			read(Reply),addKnowledge(nausia_vomit,Reply),
			Reply='y'.
addKnowledge(Cause,'y') :- asserta(has(Cause)).
addKnowledge(Cause,'n') :- asserta(has_not(Cause)).

