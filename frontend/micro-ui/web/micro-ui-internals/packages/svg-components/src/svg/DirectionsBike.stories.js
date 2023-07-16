import React from "react";
import { DirectionsBike } from "./DirectionsBike";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "DirectionsBike",
  component: DirectionsBike,
};

export const Default = () => <DirectionsBike />;
export const Fill = () => <DirectionsBike fill="blue" />;
export const Size = () => <DirectionsBike height="50" width="50" />;
export const CustomStyle = () => <DirectionsBike style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <DirectionsBike className="custom-class" />;
