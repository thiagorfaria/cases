(ns cases.a.add_tap)

;adds f, a fn of one argument, to the tap set. This function will be called with anything sent via tap>.
;This function may (briefly) block (e.g. for streams), and will never impede calls to tap>,
;but blocking indefinitely may cause tap values to be dropped.
;Remember f in order to remove-tap
