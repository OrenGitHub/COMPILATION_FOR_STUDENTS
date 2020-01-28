{-# LANGUAGE FlexibleInstances #-}

module Main( main ) where

import Code_01_div_q_r
import Prelude

import System.Environment ( getArgs )

instance Show (SigT Integer Integer) where
  show (ExistT q r) = show q ++ " (quotient) and " ++ show r ++ " (remainder)"

main = do
    (x:y:_) <- getArgs
    print $ x ++ " / " ++ y ++ " = " ++ (show (div_q_r (read x) ((read y) - 1)))

