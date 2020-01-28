module Code_01_div_q_r where

import qualified Prelude

nat_rect :: a1 -> (Prelude.Integer -> a1 -> a1) -> Prelude.Integer -> a1
nat_rect f f0 n =
  (\fO fS n -> if n Prelude.== 0 then fO () else fS (n Prelude.- 1))
    (\_ -> f)
    (\n0 -> f0 n0 (nat_rect f f0 n0))
    n

nat_rec :: a1 -> (Prelude.Integer -> a1 -> a1) -> Prelude.Integer -> a1
nat_rec =
  nat_rect

type Sig a = a
  -- singleton inductive, whose constructor was exist
  
data SigT a p =
   ExistT a p

ltb :: Prelude.Integer -> Prelude.Integer -> Prelude.Bool
ltb n m =
  (Prelude.<=) (Prelude.succ n) m

div_q_r :: Prelude.Integer -> Prelude.Integer -> SigT Prelude.Integer
           Prelude.Integer
div_q_r n =
  nat_rec (\_ -> ExistT 0 0) (\n' iHn' m0 ->
    (\fO fS n -> if n Prelude.== 0 then fO () else fS (n Prelude.- 1))
      (\_ -> ExistT (Prelude.succ n') 0)
      (\m0'' ->
      let {iHn'0 = iHn' (Prelude.succ m0'')} in
      case iHn'0 of {
       ExistT q0 h ->
        let {b = ltb h (Prelude.succ m0'')} in
        case b of {
         Prelude.True -> ExistT q0 (Prelude.succ h);
         Prelude.False -> ExistT (Prelude.succ q0) 0}})
      m0) n

