package org.bitbucket.pshirshov.izumi.di.model.plan

import org.bitbucket.pshirshov.izumi.di.model.plan.DodgyOp.{Nop, Statement}

/**
  * ***********,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,***./((%%&&&%%##((//////((((((((((((((((((((((///(((((((((//////(((
  * **************,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,***./((%%%&%###((////////(((((((((((((((((((((//(((((##############
  * .////8**************,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,**./((%%(*,***********./////////////////////////(((#%%%%%%%%%%%%%%
  * *./////////8*********,,,,,,,,,,,,,.,,,,,,,,,,,,,,,,,**.//(/.,***************.////////8*././/////.////(((%%&&&&&&&&&&&&
  * ***.////////////////8***,,,,,,,,,,,.....,,,,,,,,,,,,**./8,.,*.//////8**,./8.//////////8********.//////((#%&&&&&&&&&&&&
  * ****./////////////////8***,,,,,,,,,,......,,,,,,,,,,****. .,*.//////8***./////((((((/////////////////(((#%&&&&&&&&&&&&
  * ./8**.////////////////////8***,,,,,,,,,......,,,,,,,,,**,...,*.//////8***,,.//((((((((///////(///////((((#%%%&&&&&&&&&&&
  * (/////////////////////////8***,,,,,,,,......,,,,,,,,,,. .,,.////////8**,,,.///((((((((/////////((///(((##%&&&&&&&&&&&&&
  * #####((((((((////////////////8**,,,,,,.......,,,,,,,. ..,*.////////8**,./8,*.////////////////////////((##%&&&&&&&&&&&&&
  * ##########(((((((////////(////8**,,,,.......,,,,,,,, ..,**.////////8***./8,**.////////////////.///////((#%&&&&&&&&&&&&&
  * ((############((((((((/(((((////8**,,.......,,,,,,, ...***.////////8**,.//,*./////((/////////////////(((#%&&&&&&&&&&&&&
  * ***.//(((#####((((((((((((((///8*,,,.....,,,,,,,.  ..****.////////8***./8,.///(((((((((((((///////(((((#%%%&&&&&&&&&&&
  * ,*****./////((((((((((////////8***,,,,,,,,,,,,,,,   .,***./////////8**,***,.///((((((((((((((((((((((((((##############
  * .////////////////////////////////8***************.  .,***.//////////8**,***.////////////////(((((((((////(((((((((((((((
  * ((((((((((((/((((((((((((((((((((((/(/////////8.  ..***.///////////8**,***.////////////////////////////////////////////
  * ############################################(*   ..,**.////////////8**,***((((((((((((((///////////////////////////////
  * %%%%%%%%%%%%%%%%%%%%%%%%&&&&&&%&&&%&&&%%%%%%/   .,,,///////////////8***./#################(((((((((((((((((((//////////
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%     ..,.//(//////////8*****(&&&&&&&&&&&&&&&%%%%%%%%%%%%###########((((((((
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%,    ..,*./////////////8****,(&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%*   ..,,*.//////////////8**,,./%&&&&&&&&&&&&&&@&&@&&@@&&@@@@@@@@@@@@@@@@@@@@@
  * &&&%&&&&&&&&%&&&&&&&&&&&&&&&&&&&&&&&&&&&%/    ..,**./////////////8**,,***#&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@&@@@@@@@@@@@@
  * &%&&&&&&&&&&&&&&&%&&&&&&&&&&&&&&&&&&&&&.   ..,**.//////////////8*****,,(&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@&&@
  * %&%&&&&&&%&&%&%%&%%%%&%&&&&&&&&&&&%%%%%%.   ..,,*.///////////////8***,**,(&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@
  * &%%&&&&%&&&&%%%%%%%%%&%%&%%%%%%%%%(,,........,,,,*******.///////8****,,,,/&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@&&&&
  * %%%%%&%%%%%%%%%%%%%%%%%%%%%%%%%%%*      .,,,*****.//////8************,,,,/&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  * %%&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*     .,*.//////(((((((((/////8***,,,,,,/%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&(.   ..,.//((((((((((((((((((/////8,.  .,,*(%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%,   ..,.//(((((((######(((((((////8,,..,,./%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&. ..,,*./(((((#########((((((((///8**,,**(%&&&&&&&&&&&&&&&&&%%%%%&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&%%%%%%%%%%%%%%%%&&&&&&&&&%%/. ..,,,*((((#############(((((////8***./#%&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&
  * &%%%%%%%%%%%#%%%#%#####%%%%%%%%%%%%%/..,*.//((((((########((((((/////8.///(#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###########%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%%%%##    .,,./((###########(((((((//////(((//8****,*#%%%%%%%%%%%%%%%%%%###############%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###(.../8***.//((((##%%&&&&&&&%(*.,,,*.//////////8,*#%%%%%%%%%%%%%%%##################
  * %%%%%%%%%%%%%%%%%%%##############%###. *(((/8.//(((#%&@@@@@&&&%(/8,,,,**.//////////8,*(##%%%%%%%%%%%########%%%#######(
  * %%%%%%%%%%%%%%%##((///8*******.////((,  .(##/.//((%&@@&&@&((/8**,...,*./////////8*.   ../((####%%%%#%%%%%%%###((/////
  * #%%%%%%%%%%%%%%##((//8******,,,,*****,...,****./((#&%%%###(((//8**, ..,*./////////8*.     .,.///((##%%%%##%####(//8****
  * ##%%%%%%%%%%%%%%%###((///8***********, ..,,***,.//(((((((((##((/8,,...,*./////////8,.      .,,**./((####%######(/8*****
  * ##%%%%%%%%%%%%%%%%%%%%###(((((////////(#*.,,**,.////(((#%&&&&(/8,,..,*.////////8*,,.     ..,**.//(####%%######((/////
  * %#%%%%%%%%%%%%%%%%%%%%%%%%########((((/,,...,,.,.////((#%&&@@&/8,,..**./////////8,*,.   ..,,./(((#####%%##%#%%#######
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##,    ....,*.///((#%&&@@/8**,.,*./////////8****...,,,,*(#####%%%%%%%%%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,      ...,**.///(((##((//8**,,,,*./////////////8*****,,/%%%%%%%%%%%%%%%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%.      ..,,**.////((/////8***,,,*.///////////////////,,/#%%%%%%%%%%%%%%%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%/      .,,,**.//////(/////8***,,*.///(((/////////////8*./(%%%%%%%%%%%%%%%%%%%%%%%%
  * %%%%%%%%%%&%%%%%%%%%%%%%%%%%&%%%%%%%%#.    ..,,,***./8*.//(/////8***,*.//((((//./////((((/8****./%%%%%%%%%%%%%%%%%%%%%%
  * %%%%%%%&%%%%&&&%%&%%%%%%%%%%%%%%%%%%%%/.   .,,,**./////8./(/////.//8,,.///(((/8*.////((((/8*****./#%%%%%%%%%%%%%%%%%%%%
  * %%%%%%%%%%&&&&&&&%&&&&&%&&%%&&%%%&%%%%%*  ..,,,,,.///////(/////8.//8***.//(/8*.////(((((/8.//8***,,/%%%%%%%%%%%%%%%%%%%
  * %%&%%%%&&&&&&&&&&&&&%&%&&&%&&&&&%%%&%%(. ..,,,,,,.///(((//////8*.//8***./(/8**.////((((//.////8**,,*(#%%%&%%%%%%%%%%%%%
  * %&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%&%%,  ..,,,,,**.//////////.////8***.//(/.//////(((((////////((///8****#%&%%%%%%%%%%%
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%#.  .,,,,,,***./////////////8****.///////////(((((//((/(((#(///////8**(%&&&&&%%%%%
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%/..,,,...,,**.////////////8***.///////////(((((((((((((#%#(((//////8***#%&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%(.    ..,,,,.////////////8**.///(((((//((((((((((((((##%#((((//////8***#&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%*     ..,,,,***.////////8**.///((((((((((((##(((((((##%##((((((/////8*./%&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%*    .....,,,**.////////8*.//./(((((((##((#(####((####%##(((((((/////8*,*#&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&(.  ..,....,,,*.///////8*.///8./((((((################%%##(((((((((///8..,#&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&,   .,,,...,,,*.//////8******.//(((((################%%#(((((((((((//8,  ,#&%&&%%%
  * @@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%   ..,,,,...,*.//////8*./((/.///((((((((####(#######%%%#(((((((((((//8. .*#%%%%%%%
  * @@@@@@@@@@@&&&&&&&@&&&&&&&&&&&&&&&&%*  ..,,,****,,*.///8*..*./((((((((((((((((#((((#####%%%(((((((((((((/8,..,/%%%%%%%%
  * &&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%%%/  ..,,,,*.//(###((///8.,./((((((((((((((((#((((#####%%#(((((((((((((/8,,,*#%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%(.  .,,,,*.//((#####((//8,.//(((((((((((((((#((((####%%#(((((((((((((//8***(#%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#*  .,,,,**.//(((((###(((///////(//((((((((((#(((#####%#((((((((((((((//8*./#%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#*  ..,,,**.///((((#%%##((((((((((((((((((((((#(((###%##/8*.///((((((((////(#%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%(.  .,,****.//((//#%%%%##((((((((((//((((((((###(###%%/...,*.//((((((/(////#%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%(.  ..,,***.//////(%%%%%###(((((((((((((((((((########*....,.///(((((((((/(#%%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#,  ..,,***.//////(#%%%%%(((#((((((((((((((#((#######(, ...,.////((/(((((//#%%%%%%%%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*  ..,,*********./(#%%%%%(**(#((((((#(((((##########*....,,.///////((((((((%%%%%%%&%%%%%%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%#  ..,,,,,*.///8**./////(##*,/##(((((#((############*....,*.///////((((((((%%%%&&%&&&&&&&%
  * %%%%%%%%%%%%%%%%%%%%%%%%%%%%#*  ...,.///////((//8./////((//((##(((#############/. ...,*.////////(((((//(%&&&&&&&&&&&&&&
  * %%%%%%&&&%%%&&%&%&%%%%%%%%%#,  .,./////(((////./((####/8((((((###############(.  ..,*.////////((((((/8./%&&&&&&&&&&&&&&
  * &%%%&&&%&%&&&&&%&%%&&&&&%%%* .,./////((////8**#%%%%%##(/(###################,.....,.///////////(((///8./%&&&&&&&&&&&&&&
  * %&&&&&&&&&&&&&&&&&&&&&&&&%*.../////((((((#%%#./#%%%%%%#(#%%%%%############*. ...,*.////////////((////8,*#&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&%*,.////(((((##%%%%%%(./%%%%%(%&%&&%(##########*....,**.////////////((((((/8,*#&@@@@@@@@@@@@@
  * &&&&&&&&&&&&&&&&&&&&&&%/,./////(((##%%%%%%%%%#/8(%&&&(%&&&#%%#(####/8****./////////////((((((#((/8**(@@@@@@@@@@@@@@
  * &&&&&&&&&&&&&&&&&&&&&%*,./////((((#%&&%%%%%%%%(/(%&&&#%&&&%&&%(##(////////////////////((((((###((/8,/@@@@@@@@@@@@@@
  * &&&&&&&&&&&&&&&&&&&&%/.///((((##/8./#%&%%%%&%%%//%&&&#&&&&%#&&&%#((///////((////////////(///(####((/8**&@@@@@@@@@@@@@
  * &&&&&&&&&&&&&&&&&&,,///(((###%%%(/./(%%%&%%%%(/%&&&%#%&&@%&&%#((//////((((((////(((((((//(#%###((/8**%@@&&&&&&&&&&&
  * &&&&&&&&&&&&&&@&&%*,.//(((###%%&&&&%#/8*(%&&%&(#%&&%#&@&@%%&%#(((((/((((((((/////(((((((((((######(/8**(&&&&&&&&&&&&&
  * @@@@@@@@@@@@@@@@%*,.//((###%%%&&&&&&&%#/8(%%&&(#%&%&@@&%##((((((/(((((/(((////((((((((((########((/8./%&&&&&&&&&&&&
  * @@@@@@@@@@@@@@@&*,.//((###%%%&&&&&&&&&/8((%&(#&&%%%&&%#(((((((((((((((/(((((((((((((((##########((/8./#&&&&&&&&&&&&
  * @@@@@@@@@@@@@@@,..//((###%%&&&&&&&&&%%&//(%&##&@%%%%#(((((((((((((((((((((((((((((((((######%###((/8**(&&&&&&&&&&&&
  * @@@@@@@@@@@@@&*..//(###%%%&&&&%%%%&&&&&&((%&#%@##((((((//(((((((((((((((((((((((((#%%#####%####((/8./#&&&&&&&&&&&
  * @@@@@@@@@@@&&/.*(((##%%%%&&%%%%%%&&&%#&&&(#&%%%&%###(((((((((((((((((((((((((((((((((#%%####(#%####((/8**(%&&&&&&&&&&
  * &&&&&&&&&&&&(..(((###%#((//////////(#/(%&(##%%&&%%###((((((((((((((((((((((((((((((((#%%%#####%####((//8./%&&&&&&&&&&
  * &&&&&&&&&&,,/(###%%#####%%%%%%#(///(((#%##%&&&@&%%%####((((((((((((((((((((((((((((###%%%######%####((/8./(%&&&&&&&&&
  * &&&&&&&&&&%/./((###%%%%%&&&&&&%%&&&%#((((#%%%&&@&%#########(((((((((((((((((((((((((####%%%######%####((/8.//#&&&&&&&&&
  * &&&&&&&&&&(./((##%%%%%%&&&&&&&&&&&&&&%##%#%%%%#((((((###%###(((((((((((((((((((((((#####%%%%#####%####((/8.//(#&&&&&&&&
  * &&&&&&&&&%/./((#%%%%%&&&&&&&&&%%%&&&&%%%%&%#((///8*./((##%%####(((((((((((((((((((#%%###%%%%#####%#####(/8*.//(%&&&&&&&
  * &&&&&&&&%/./((#%%%%%&&&&&&%%%%%%######%&&&%#((//8,.,.//((#%%%####(((((((/((((((((#%%%###%%%%#####%%####((/8.//((%%&&&&&
  * &&&&&&&./((##%%%%%&&&&%%#((((((((##%&&&&%%##((////////((#%%%####((((((((((((((#%%%%%##%%%%#####%%####((/8.///(#&&&&&&
  * &&&&&&&%/./(###%%%%&&&%#(///(#%%%&%%%&&&@&&%%%####((/////((%%%%####((((((((((((#%%%%%%##%%%%#####%%%###((/8.///((%&&&&&
  * &&&&&&./((##%%%%&&%#///#%%&&&&&&&%&&&@&%%%%#((((////////(#%%%####(((((((((((#%%%%%%%##%%%%%####%%#####((/8.///(#&&&&&
  * &&&&&&&/./(##%%%%%%(//#%&&&&&&&%%#%%&&@&%#(((//8,,.//(////(#%%%%####((((((((#%%%%%%%%%%%%%%%%####%%%####((/8*.//((%&&&&
  * &&&&&&&//((##%%%#(/(#%&&&&&&%#####%&&&&&%#((//8*.///(((((/(##%%%%####((((((#%%%%%%%%%%%%%%%%%%###%%%#####((/8.//((%&&&&
  * &&&&&&%//(##%%%#(#%&&&&&&&&&%###%&&&&&&&&%##(////(((//((((/(#%&%%%####((((#%%%%%%%%%%%%%%%%%%%###%%%#####((/.///(#%&&&&
  * &&&&&/(##%%%%%&&&&&&&&&&%###&&@&%&&@@&@&%%#(((((///(((((/(%&&&%%%###(((#%%%%%%%%%%%%%%%%%%%%###%%%%####(((////(#%&&&&
  * &&&&&/(#%%%%%&&&&&&&&%#(#%&@@&%%%&&@@@@&%%%#((//./((((//(%&&&&&%%#####%%%%%%%%&%%%%%%%%%%%%%%##%%%%%####((///((#&&&&&
  * &&&&&/##%%%%%&&&&&&((#&&@@%%%%&&&@@@@&%%#((////////(//#&&&&&&%%####%%%%%%%%%&&%%%%%%%%%%%%%##%%%%%####(((((((%&&&&&
  * &&&&&(##%%%&&&&&&&(#%&&&&%%%&@&&&&&&@@&%##((/(((//((//%%&&&&&%%###%%%%%%%%%%&&%%%%%%%%%%%%%#%%%%%%%###((((((#&&&&&&
  * &&&&&(#%%%%&&&&&&%((%&&@@&%%%&@&%&&&&&&&&&&%%####(/(((/(#(#%&%%%%##%%%%%%%%%%&&%%%%%%%%%%%%%%%%%%%%%%####(((((%&&&&&&
  * &&&&&(#%%%%&&&&((%&&&&&%#%@@&%%&@%%&@&&&@&%%###((#(//%&%#(/((####%%%%%%%%%%&&&%%%%%%%%&%%%%%%%%%%%%%###(((#%&&&&&&&
  * &&&&&(#%%%%&&&%#(#&&&&&#%&@&%%&@%&@%%%&&&&&%%%%#((#&@@@((####%%%%%%%%%&&&&&%%%%%%&&%%%%%%%&&%%%%%###%&&&&&&&&&&
  * &&&&&&%(##%%&&&%((%&&&&&#%@@&%%&@#%&#(&&&&@&&&&&&&&&@@@@@@&%%%%%%%%%&%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&((#%%%&%(#%&&&&&%((%&&&%#%&&%##&&&%%(%&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&%%%&&&&&&&
  * &&&&&&(#%%%&&%&&&&&&(%&&&#&&&%##&&&&(%&&&&&&&&&&&%%&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&%%%&&&&&&&
  * &&&&&&&%(##%%&&&&&&&&(%&&&&%(%&&&%&&&&&&((%&&&&&&&&%%%%%%%&&&&&&&&&&&@&&&&&&@@&&@@@@@@@@@@@@@&@@@&&&&&&&&&%%&&&&&&&
  * &&&&&&&(#%%%&&&&&&&%(%&&&&#&&&&&(%&&&&&&%((#&&&&&&&%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%&&&&&&&
  * &&&&&&&&(#%%&&&&&&#&&&&&%(%&&&&&(%&&&&&&&&%#%&&&&&&%%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%&&&&
  * &&&&&&&&&&%##%%&&&&(&&&&&&%(&&&&&#&&@@&&&&&&&&&&&&&&%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%
  * &&&&&&&&&&&%##%&&&&%#%@&&&&(&&&&&#&@@@@@&&&&&&&&&&&&&%%%%%%%%%&&&&&&&&&@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&&&%%%&&&&&&&
  * &&&&&&&&&&&&%%#%%%%#%&@&@&&&(#&&&&&@%(%&&@@@@@@@@@@@@&&&&&&%%%%%%&&&&&&&@@@@@@@@@@@@@@@@&@@@@@@&&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&%%%%&&&&&@&&%(%@@@@@&%@@@@@@@@@@@@@@@@&&&&%%%%%%&&&&&&&&@&&@&&&@@@@@@@@&@@@@@@@&&&&&&&&&&&&&&&&&&&&&&&
  * &&&&&&&&&&&&&&&&&&&&&&&&&&&%#&&&&&&@@@@&&&&&&&&&&&&&@@@&&&&&%%%%%%&&&&&&&&&&@@@@@@@@&@@@&&@@&&&&&&&&&&&&&&&&&&&&&&&&&&&
  **/
case class DodgyPlan(
                      imports: Set[Statement]
                     , sets: Set[Statement]
                     , steps: Seq[DodgyOp]
                    ) {
  def flatten: Seq[DodgyOp] = imports.toSeq ++ sets.toSeq ++ steps

  def statements: Seq[ExecutableOp] = flatten.collect {case s: Statement => s.op}

  override def toString: String = flatten.collect {
    case Statement(op) =>
      op.format
    case Nop(message) =>
      message
    case v =>
      v.toString
  }.mkString("\n")
}

object DodgyPlan {
  def empty: DodgyPlan = DodgyPlan(Set.empty, Set.empty, Seq.empty)
}
