(***********)
(* IMPORTS *)
(***********)
Require Import Coq.Arith.PeanoNat.
Require Import Coq.Structures.OrdersFacts.

Lemma Sn_eq_Sm: forall n m,
  (n = m) -> ((S n) = (S m)).
Proof.
  intros n m H.
  rewrite H.
  reflexivity.
Qed.

Lemma Sn_lt_Sm: forall n m,
  (n < m) -> ((S n) < (S m)).
Proof.
  intros n0 m0 H.
  unfold lt in H.
  apply Nat.lt_succ_r.
  apply H.
Qed.

Lemma add_nSm : forall (n m : nat),
  (n + (S m)) = S (n + m).
Proof.
  intros n m.
  induction n.
  - reflexivity.
  - simpl.
    apply Sn_eq_Sm.
    apply IHn.
Qed.

Lemma n_lt_m: forall n m,
  ((n <? m) = false) -> (m <= n).
Proof.
Admitted.

Lemma n_le_m_le_n: forall n m,
  (n <= m) -> ((m <= n) -> (m = n)).
Proof.
Admitted.

Lemma Sn_ge_0: forall n,
  0 <= (S n).
Proof.
  induction n as [|n' IHn'].
  - apply le_S. apply le_n.
  - apply le_S. apply IHn'.
Qed.

Lemma n_ge_0: forall n,
  0 <= n.
Proof.
  induction n as [|n' IHn'].
  - apply le_n.
  - apply le_S. apply IHn'.
Qed.

Lemma Sn_gt_0: forall n,
  0 < (S n).
Proof.
  induction n as [|n' IHn'].
  - apply le_n.
  - apply le_S. apply IHn'.
Qed.

Lemma n_le_m_implies_Sn_le_Sm: forall n m,
  (n <= m) -> ((S n) <= (S m)).
Proof.
  induction n as [|n' IHn'].
  - induction m as [|m' IHm'].
    + intros H1. apply le_n.
    + intros H1. apply le_S.
      apply IHm'. apply n_ge_0.
  - induction m as [|m' IHm'].
    + intros H1. inversion H1. 
    + intros H1. inversion H1. 
      apply le_n. apply IHm' in H0 as H2.
      apply le_S in H2. apply H2.
Qed.

(****************************************)
(* division with quotient and remainder *)
(****************************************)
Definition div_q_r: forall n m : nat,
   {     q:nat & {     r:nat | (n = q * (S m) + r) /\ (r < (S m))}}.
Proof.
  induction n as [|n' IHn'].
  - exists 0. exists 0. split. reflexivity. apply Sn_gt_0.
  - intros m0.
    destruct m0 as [|m0''] eqn:E1.
    + exists (S n'). exists 0. split.
      * rewrite Nat.add_0_r with (n:=(S n') * 1).
        rewrite Nat.mul_1_r with (n:=(S n')). reflexivity.
      * specialize Sn_gt_0 with (n:=0). intros H. apply H.
    + specialize IHn' with (m:=(S m0'')).
      destruct IHn' as [q0 H]. destruct H as [r0 H].
      destruct (r0 <? (S m0'')) eqn:E2.
      * exists q0. exists (S r0). split.
        -- rewrite add_nSm with (n:=q0 * S (S m0'')). 
           apply Sn_eq_Sm. apply proj1 in H as H1. apply H1.
        -- apply Nat.ltb_lt in E2. apply Sn_lt_Sm. apply E2.
      * exists (S q0). exists 0. split.
        -- apply proj2 in H as H2. rewrite Nat.lt_succ_r in H2.
           apply n_lt_m in E2. apply n_le_m_le_n in H2.
           apply proj1 in H as H1. rewrite H2 in H1. rewrite H1.
           rewrite <- add_nSm with (n:=q0 * S (S m0'')) (m:=S m0'').
           rewrite Nat.add_0_r.
           rewrite Nat.mul_succ_l with (n:=q0) (m:=S (S m0'')).
           reflexivity. apply E2.
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
Extraction "/home/oren/GIT/CoqIt/FOLDER_2_PRESENTATION/FOLDER_2_EXAMPLES/EXAMPLE_06_Discarding_Proofs_Haskell.hs" div_q_r.
