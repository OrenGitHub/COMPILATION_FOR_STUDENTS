(***********)
(* IMPORTS *)
(***********)
Require Import Coq.Arith.PeanoNat.
Require Import Coq.Structures.OrdersFacts.
Require Import Coq.Arith.Gt.
Require Import Coq.Arith.Lt.
Require Import Coq.Arith.Arith.

(****************************************)
(* division with quotient and remainder *)
(****************************************)
Definition div_q_r: forall n m : nat,
  { q:nat & { r:nat |
  (n = q * (S m) + r) /\ (r < (S m))}}.
Proof.
  induction n as [|n' IHn'].
  (* rest of proof ... *)
  - exists 0. exists 0. split. reflexivity. apply gt_Sn_O.
  - intros m0.
    specialize IHn' with (m:=m0).
    destruct IHn' as [q0 H]. destruct H as [r0 H].
    destruct ((S r0) <? (S m0)) eqn:E2.
    * exists q0. exists (S r0). split.
      -- apply proj1 in H as H1.
         rewrite H1.
         rewrite Peano.plus_n_Sm with (n:=q0 * S m0).
         reflexivity.
      -- apply Nat.ltb_lt in E2. apply E2.
    * exists (S q0). exists 0. split.
      -- apply proj2 in H as H2. rewrite Nat.lt_succ_r in H2.
         rewrite Nat.ltb_ge in E2.
         specialize le_S_n with (n:=r0) (m:=m0).
         intros H3.
         specialize Nat.ltb_lt with (n:=(S r0)) (m:=(S m0)).
         intros H3. rewrite E2 in H3.
         apply n_le_m_le_n in H2.
         apply proj1 in H as H1. rewrite H2 in H1. rewrite H1.
         rewrite <- add_nSm with (n:=q0 * (S m0)) (m:=m0).
         rewrite Nat.add_0_r.
         rewrite Nat.mul_succ_l with (n:=q0) (m:=(S m0)).
         reflexivity. apply Sn_le_Sm_implies_n_le_m.
      -- unfold "<". apply n_le_m_implies_Sn_le_Sm. apply Sn_ge_0.
Qed.

(********************************)
(* Extraction Language: Haskell *)
(********************************)
Extraction Language Haskell.

(***************************)
(* Use Haskell basic types *)
(***************************)
Require Import ExtrHaskellBasic.

(****************************************)
(* Use Haskell support for Nat handling *)
(****************************************)
Require Import ExtrHaskellNatNum.
Extract Inductive Datatypes.nat => "Prelude.Integer" ["0" "Prelude.succ"]
"(\fO fS n -> if n Prelude.== 0 then fO () else fS (n Prelude.- 1))".

(***************************)
(* Extract to Haskell file *)
(***************************)
Extraction "/home/oren/GIT/COMPILATION_FOR_STUDENTS/FOLDER_1_SLIDES/SLIDES_06_Advanced/FOLDER_7_HSKLFILES/Code_01_div_q_r.hs" div_q_r.
