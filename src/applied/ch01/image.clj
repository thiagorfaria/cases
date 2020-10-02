(ns applied.ch01.image
  (:require [clojure.java.io :as io])
  (:import [java.awt.image BufferedImage]
           [javax.imageio ImageIO]))

(defrecord PlanetImage [src ^BufferedImage contents])

(defn- make-planet-image
  "Make a PlanetImage; may throw IOException"
  [src]
  (with-open [img (ImageIO/read (io/input-stream src))]
    (->PlanetImage src img)))


